package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.AssignmentSubmission;
import com.geneza.lms.persistence.AssignmentSubmissionRepository;
import com.geneza.lms.service.AssignmentSubmissionService;
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


@Controller("AssignmentSubmissionRestController")
public class AssignmentSubmissionRestController {

    @Autowired
    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    @Autowired
    private AssignmentSubmissionService assignmentSubmissionService;

    @RequestMapping(value = "/AssignmentSubmission", method = RequestMethod.PUT)
    @ResponseBody
    public AssignmentSubmission saveAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission) {
    assignmentSubmissionService.saveAssignmentSubmission(assignmentSubmission);
        return assignmentSubmissionRepository.findById(assignmentSubmission.getId());
    }

    @RequestMapping(value = "/AssignmentSubmission", method = RequestMethod.POST)
    @ResponseBody
    public AssignmentSubmission newAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission) {
    assignmentSubmissionService.saveAssignmentSubmission(assignmentSubmission);
        return assignmentSubmissionRepository.findById(assignmentSubmission.getId());
    }

    @RequestMapping(value = "/AssignmentSubmission", method = RequestMethod.GET)
    @ResponseBody
    public List<AssignmentSubmission> listAssignmentSubmissions() {
        return new java.util.ArrayList<AssignmentSubmission>(assignmentSubmissionService.findAll());
    }

    @RequestMapping(value = "/AssignmentSubmission/{assignmentSubmission_id}", method = RequestMethod.GET)
    @ResponseBody
    public AssignmentSubmission loadAssignmentSubmission(@PathVariable Integer assignmentSubmission_id) {
        return assignmentSubmissionService.findById(assignmentSubmission_id);
    }

    @RequestMapping(value = "/AssignmentSubmission/Delete/{assignmentSubmission_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteAssignmentSubmission(@PathVariable Integer assignmentSubmission_id) {
        return assignmentSubmissionService.deleteAssignmentSubmission(assignmentSubmission_id);
    }
    @RequestMapping(value = "/AssignmentSubmission/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<AssignmentSubmission> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (assignmentSubmissionRepository.findAll(pageable));
    }

 @RequestMapping(value = "/AssignmentSubmission/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<AssignmentSubmission> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (assignmentSubmissionRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/AssignmentSubmission/Assignment/{assignment_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<AssignmentSubmission> getAllByAssignmentId(@PathVariable("assignment_id") Integer assignmentId) {
        return new java.util.ArrayList<AssignmentSubmission>(assignmentSubmissionService.findAllByAssignmentId(assignmentId));
    }

    @RequestMapping(value = "/AssignmentSubmission/Enrollment/{enrollment_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<AssignmentSubmission> getAllByEnrollmentId(@PathVariable("enrollment_id") Integer enrollmentId) {
        return new java.util.ArrayList<AssignmentSubmission>(assignmentSubmissionService.findAllByEnrollmentId(enrollmentId));
    }

    @RequestMapping(value = "/AssignmentSubmission/SubmissionStatus/{submissionStatus_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<AssignmentSubmission> getAllBySubmissionStatusId(@PathVariable("submissionStatus_id") Integer submissionStatusId) {
        return new java.util.ArrayList<AssignmentSubmission>(assignmentSubmissionService.findAllBySubmissionStatusId(submissionStatusId));
    }

}