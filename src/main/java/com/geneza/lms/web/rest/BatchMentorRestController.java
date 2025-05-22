package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.BatchMentor;
import com.geneza.lms.persistence.BatchMentorRepository;
import com.geneza.lms.service.BatchMentorService;
import java.util.List;
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


@Controller("BatchMentorRestController")
public class BatchMentorRestController {

    @Autowired
    private BatchMentorRepository batchMentorRepository;

    @Autowired
    private BatchMentorService batchMentorService;

    @RequestMapping(value = "/BatchMentor", method = RequestMethod.PUT)
    @ResponseBody
    public BatchMentor saveBatchMentor(@RequestBody BatchMentor batchMentor) {
    batchMentorService.saveBatchMentor(batchMentor);
        return batchMentorRepository.findById(batchMentor.getId());
    }

    @RequestMapping(value = "/BatchMentor", method = RequestMethod.POST)
    @ResponseBody
    public BatchMentor newBatchMentor(@RequestBody BatchMentor batchMentor) {
    batchMentorService.saveBatchMentor(batchMentor);
        return batchMentorRepository.findById(batchMentor.getId());
    }

    @RequestMapping(value = "/BatchMentor", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchMentor> listBatchMentors() {
        return new java.util.ArrayList<BatchMentor>(batchMentorService.findAll());
    }

    @RequestMapping(value = "/BatchMentor/{batchMentor_id}", method = RequestMethod.GET)
    @ResponseBody
    public BatchMentor loadBatchMentor(@PathVariable Integer batchMentor_id) {
        return batchMentorService.findById(batchMentor_id);
    }

    @RequestMapping(value = "/BatchMentor/Delete/{batchMentor_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteBatchMentor(@PathVariable Integer batchMentor_id) {
        return batchMentorService.deleteBatchMentor(batchMentor_id);
    }

 @RequestMapping(value = "/BatchMentor/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<BatchMentor> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (batchMentorRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/BatchMentor/Batch/{batch_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchMentor> getAllByBatchId(@PathVariable("batch_id") Integer batchId) {
        return new java.util.ArrayList<BatchMentor>(batchMentorService.findAllByBatchId(batchId));
    }

    @RequestMapping(value = "/BatchMentor/Mentor/{mentor_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchMentor> getAllByMentorId(@PathVariable("mentor_id") Integer mentorId) {
        return new java.util.ArrayList<BatchMentor>(batchMentorService.findAllByMentorId(mentorId));
    }

    @RequestMapping(value = "/BatchMentor//by-person/{personId}", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchMentor> getBatchMentorsByPersonId(@PathVariable Integer personId) {
        return batchMentorService.findByPersonId(personId);
    }

}