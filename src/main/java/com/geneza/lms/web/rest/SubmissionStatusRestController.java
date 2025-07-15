package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.SubmissionStatus;
import com.geneza.lms.persistence.SubmissionStatusRepository;
import com.geneza.lms.service.SubmissionStatusService;
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


@Controller("SubmissionStatusRestController")
public class SubmissionStatusRestController {

    @Autowired
    private SubmissionStatusRepository submissionStatusRepository;

    @Autowired
    private SubmissionStatusService submissionStatusService;

    @RequestMapping(value = "/SubmissionStatus", method = RequestMethod.PUT)
    @ResponseBody
    public SubmissionStatus saveSubmissionStatus(@RequestBody SubmissionStatus submissionStatus) {
    submissionStatusService.saveSubmissionStatus(submissionStatus);
        return submissionStatusRepository.findById(submissionStatus.getId());
    }

    @RequestMapping(value = "/SubmissionStatus", method = RequestMethod.POST)
    @ResponseBody
    public SubmissionStatus newSubmissionStatus(@RequestBody SubmissionStatus submissionStatus) {
    submissionStatusService.saveSubmissionStatus(submissionStatus);
        return submissionStatusRepository.findById(submissionStatus.getId());
    }

    @RequestMapping(value = "/SubmissionStatus", method = RequestMethod.GET)
    @ResponseBody
    public List<SubmissionStatus> listSubmissionStatuss() {
        return new java.util.ArrayList<SubmissionStatus>(submissionStatusService.findAll());
    }

    @RequestMapping(value = "/SubmissionStatus/{submissionStatus_id}", method = RequestMethod.GET)
    @ResponseBody
    public SubmissionStatus loadSubmissionStatus(@PathVariable Integer submissionStatus_id) {
        return submissionStatusService.findById(submissionStatus_id);
    }

    @RequestMapping(value = "/SubmissionStatus/Delete/{submissionStatus_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteSubmissionStatus(@PathVariable Integer submissionStatus_id) {
        return submissionStatusService.deleteSubmissionStatus(submissionStatus_id);
    }
    @RequestMapping(value = "/SubmissionStatus/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<SubmissionStatus> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (submissionStatusRepository.findAll(pageable));
    }

 @RequestMapping(value = "/SubmissionStatus/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<SubmissionStatus> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (submissionStatusRepository.findAll(sortedPaged));
    }


}