package com.geneza.lms.service;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.geneza.lms.service.ParticipantService.ParticipantDto;

import org.springframework.web.client.HttpClientErrorException;

@Service
public class ParticipantService {

    private static final String BASE_URL = "https://backend.staging.autographa.io/survey";
    private final RestTemplate restTemplate = new RestTemplate();

    public Long findOrCreateParticipant(Long personId, String fullName, String email, String role) {
    try {
        // STEP 1: Try to fetch existing participant by personId using the new endpoint
        String url = BASE_URL + "/Participant/Person/" + personId;
        ResponseEntity<ParticipantDto[]> response = restTemplate.exchange(
    url,
    HttpMethod.GET,
    null,
    ParticipantDto[].class
);


        ParticipantDto[] participants = response.getBody();
    if (participants != null && participants.length > 0) {
        return participants[0].getId();
    }

    } catch (HttpClientErrorException e) {
        // Participant not found — proceed to create
    } catch (Exception e) {
        throw new RuntimeException("Error checking participant existence", e);
    }

    // STEP 2: Create new participant
    try {
        ParticipantDto requestBody = new ParticipantDto();
        ParticipantDto.PersonDto personDto = new ParticipantDto.PersonDto();
        personDto.setId(personId);
        requestBody.setPerson(personDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ParticipantDto> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<ParticipantDto> createResponse = restTemplate.postForEntity(
            BASE_URL + "/Participant",
            entity,
            ParticipantDto.class
        );

        if (createResponse.getStatusCode().is2xxSuccessful() && createResponse.getBody() != null) {
            return createResponse.getBody().getId();
        } else {
            throw new RuntimeException("Failed to create participant. Response: " + createResponse);
        }

    } catch (Exception e) {
        throw new RuntimeException("Error creating participant", e);
    }
}



     // DTO class to map request and response
    public static class ParticipantDto {
    private Long id;
    private PersonDto person;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public PersonDto getPerson() { return person; }
    public void setPerson(PersonDto person) { this.person = person; }

    public static class PersonDto {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String role;

        // Add other fields if needed

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }
    }
}

}
