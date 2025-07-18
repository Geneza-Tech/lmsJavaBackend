package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.BatchMentorRepository;
import com.geneza.lms.persistence.BatchSurveyRepository;
import com.geneza.lms.persistence.BatchTrainerRepository;
import com.geneza.lms.persistence.EnrollmentRepository;
import com.geneza.lms.persistence.PersonRepository;
import com.geneza.lms.domain.BatchMentor;
import com.geneza.lms.domain.BatchSurvey;
import com.geneza.lms.domain.BatchTrainer;
import com.geneza.lms.domain.Enrollment;
import com.geneza.lms.dto.ResponseDTO;
import com.geneza.lms.dto.ResponseParticipant;
import com.geneza.lms.dto.ResponseSurvey;
import com.geneza.lms.service.BatchSurveyService;
import com.geneza.lms.service.ParticipantService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service("BatchSurveyService")
@Transactional
public class BatchSurveyServiceImpl implements BatchSurveyService {

    @Autowired
    private BatchSurveyRepository batchSurveyRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private BatchMentorRepository batchMentorRepository;

    @Autowired
    private BatchTrainerRepository batchTrainerRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ParticipantService participantService;



    @Autowired
    private RestTemplate restTemplate;

    private static final String RESPONSE_API_URL = "https://backend.staging.autographa.io/survey/Response";
    private static final String RESPONSE_SEARCH_API = "https://backend.staging.autographa.io/survey/Response/search";


    public BatchSurveyServiceImpl() {
    }

    @Transactional
    public BatchSurvey findById(Integer id) {
        return batchSurveyRepository.findById(id);
    }

    @Transactional
    public List<BatchSurvey> findAll() {
        return batchSurveyRepository.findAll();
    }
     
    @Override
@Transactional
public void saveBatchSurvey(BatchSurvey batchSurvey) {
    Integer batchId = batchSurvey.getBatch().getId();
    Integer surveyId = batchSurvey.getSurveyId();
    String recipientRole = batchSurvey.getReceipientRole();
    String linkRole = batchSurvey.getLinkRole();

    List<Integer> personIds = getPersonIdsByRole(batchId, recipientRole);
    if (personIds == null || personIds.isEmpty()) {
        throw new RuntimeException("No participants found for batch ID: " + batchId + " and role: " + recipientRole);
    }

    List<Integer> linkPersonIds = new ArrayList<>();
    if (linkRole != null && !linkRole.trim().isEmpty()) {
        linkPersonIds = getPersonIdsByRole(batchId, linkRole);
        if (linkPersonIds == null || linkPersonIds.isEmpty()) {
            throw new RuntimeException("No link participants found for batch ID: " + batchId + " and role: " + linkRole);
        }
    }

    List<String> failedResponses = new ArrayList<>();

    for (Integer personId : personIds) {
        if (linkPersonIds.isEmpty()) {
            boolean success = createResponseFromPerson(personId.longValue(), null, surveyId, batchId, null,null, recipientRole);
            if (!success) {
                failedResponses.add("Person: " + personId);
            }
        } else {
            for (Integer linkPersonId : linkPersonIds) {
                boolean success = createResponseFromPerson(personId.longValue(), linkPersonId.longValue(), surveyId, batchId, linkRole, null,recipientRole);
                if (!success) {
                    failedResponses.add("Person: " + personId + ", Link: " + linkPersonId);
                }
            }
        }
    }

    if (!failedResponses.isEmpty()) {
        throw new RuntimeException("Failed to create survey responses: " + String.join("; ", failedResponses));
    }

    batchSurveyRepository.save(batchSurvey);
}


    private boolean createResponseFromPerson(Long personId, Long linkPersonId, Integer surveyId, Integer batchId, String linkType, String linkComment, String recipientRole) {
    try {
        Long participantId = participantService.findOrCreateParticipant(personId, null, null ,recipientRole);
        if (participantId == null) {
            throw new RuntimeException("Could not resolve participantId for personId: " + personId);
        }

        Long linkParticipantId = null;
        if (linkPersonId != null) {
            linkParticipantId = participantService.findOrCreateParticipant(linkPersonId, null, null,recipientRole);
            if (linkParticipantId == null) {
                throw new RuntimeException("Could not resolve link participantId for personId: " + linkPersonId);
            }
        }

        // Check if response already exists
        if (checkIfResponseExists(batchId, personId, linkParticipantId != null ? linkParticipantId.intValue() : null, surveyId)) {
            System.out.println("Response already exists for personId=" + personId);
            return true;
        }


        ResponseDTO dto = new ResponseDTO();
        dto.setParticipant(new ResponseParticipant(participantId.intValue()));
        dto.setSurvey(new ResponseSurvey(surveyId));
        dto.setBatchId(batchId);
        dto.setLinkId(linkParticipantId != null ? linkParticipantId.intValue() : null);
        dto.setLinkType(linkType);
        dto.setLinkcomment(linkComment);

                HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ResponseDTO> request = new HttpEntity<>(dto, headers);

        ResponseEntity<ResponseDTO> response = restTemplate.postForEntity(RESPONSE_API_URL, request, ResponseDTO.class);

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new RuntimeException("Response creation failed. Status: " + response.getStatusCode());
        }

        return true;
    } catch (Exception e) {
        System.err.println("Failed to create response for personId=" + personId +
            ", linkPersonId=" + linkPersonId + " → " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}






    private boolean checkIfResponseExists(Integer batchId, Long participantId, Integer linkId, Integer surveyId) {
        try {
            ResponseDTO[] responses = restTemplate.getForObject(
                RESPONSE_SEARCH_API + "?batchId={batchId}&personId={participantId}&linkId={linkId}&surveyId={surveyId}",
                ResponseDTO[].class,
                batchId, participantId, linkId, surveyId
            );
            return responses != null && responses.length > 0;
        } catch (Exception e) {
            // log.error("Error checking existing responses", e);
            return false;
        }
    }

    private List<Integer> getPersonIdsByRole(Integer batchId, String role) {
        switch (role.toUpperCase()) {
            case "MTT":
                return enrollmentRepository.findByBatchIdAndRole(batchId, "MTT")
                        .stream().map(e -> e.getStudent().getId()).collect(Collectors.toList());
            case "QC":
                return enrollmentRepository.findByBatchIdAndRole(batchId, "QC")
                        .stream().map(e -> e.getStudent().getId()).collect(Collectors.toList());
            case "LQC":
                return enrollmentRepository.findByBatchIdAndRole(batchId, "LQC")
                        .stream().map(e -> e.getStudent().getId()).collect(Collectors.toList());
             case "ICT":
                return enrollmentRepository.findByBatchIdAndRole(batchId, "ICT")
                        .stream().map(e -> e.getStudent().getId()).collect(Collectors.toList());            
            case "MENTOR":
                return batchMentorRepository.findAllByBatchId(batchId)
                        .stream().map(bm -> bm.getMentor().getId()).collect(Collectors.toList());

            case "TRAINER":
            return batchTrainerRepository.findAllByBatchId(batchId)
                    .stream().map(bt -> bt.getTrainer().getId()).collect(Collectors.toList());

            default:
                return Collections.emptyList();
        }
    }

    public boolean deleteBatchSurvey(Integer batchSurveyId) {
        BatchSurvey batchSurvey = batchSurveyRepository.findById(batchSurveyId);
        if(batchSurvey!=null) {
            batchSurveyRepository.delete(batchSurvey);
            return true;
        }else {
            return false;
        }
    }
    
    @Transactional
    public List<BatchSurvey> findAllByBatchId(Integer  batchId) {
        return new java.util.ArrayList<BatchSurvey>(batchSurveyRepository.findAllByBatchId(batchId));
    }

    

}