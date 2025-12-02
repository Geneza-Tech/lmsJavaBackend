package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.BatchSurvey;
import com.geneza.lms.persistence.BatchSurveyRepository;
import com.geneza.lms.service.BatchSurveyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.geneza.lms.dto.BatchSurveyAssignAllDTO;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Controller("BatchSurveyRestController")
public class BatchSurveyRestController {

    @Autowired
    private BatchSurveyRepository batchSurveyRepository;

    @Autowired
    private BatchSurveyService batchSurveyService;

    @RequestMapping(value = "/BatchSurvey", method = RequestMethod.PUT)
    @ResponseBody
    public BatchSurvey saveBatchSurvey(@RequestBody BatchSurvey batchSurvey) {
    batchSurveyService.saveBatchSurvey(batchSurvey);
        return batchSurveyRepository.findById(batchSurvey.getId());
    }

    @RequestMapping(value = "/BatchSurvey", method = RequestMethod.POST)
@ResponseBody
public ResponseEntity<?> newBatchSurvey(@RequestBody BatchSurvey batchSurvey) {
    try {
        batchSurveyService.saveBatchSurvey(batchSurvey);
        BatchSurvey savedSurvey = batchSurveyRepository.findById(batchSurvey.getId());
        return ResponseEntity.ok(savedSurvey);
    } catch (RuntimeException ex) {
        Map<String, String> errorBody = new HashMap<>();
        errorBody.put("error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorBody);
    }
}


    @RequestMapping(value = "/BatchSurvey", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchSurvey> listBatchSurveys() {
        return new java.util.ArrayList<BatchSurvey>(batchSurveyService.findAll());
    }

    @RequestMapping(value = "/BatchSurvey/{batchSurvey_id}", method = RequestMethod.GET)
    @ResponseBody
    public BatchSurvey loadBatchSurvey(@PathVariable Integer batchSurvey_id) {
        return batchSurveyService.findById(batchSurvey_id);
    }

    @RequestMapping(value = "/BatchSurvey/Delete/{batchSurvey_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteBatchSurvey(@PathVariable Integer batchSurvey_id) {
        return batchSurveyService.deleteBatchSurvey(batchSurvey_id);
    }

 @RequestMapping(value = "/BatchSurvey/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<BatchSurvey> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (batchSurveyRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/BatchSurvey/Batch/{batch_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchSurvey> getAllByBatchId(@PathVariable("batch_id") Integer batchId) {
        return new java.util.ArrayList<BatchSurvey>(batchSurveyService.findAllByBatchId(batchId));
    }

   @RequestMapping(value = "/BatchSurvey/AssignAll", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> assignSurveyToAll(@RequestBody BatchSurveyAssignAllDTO dto) {

        try {
            batchSurveyService.assignSurveyToAllRoles(dto);
            return ResponseEntity.ok("Survey assigned to all roles in batch successfully");
        } catch (RuntimeException ex) {
            Map<String, String> error = new HashMap<>();
            error.put("error", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }



}