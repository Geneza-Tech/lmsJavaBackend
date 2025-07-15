package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.Assignment;
import com.geneza.lms.persistence.AssignmentRepository;
import com.geneza.lms.service.AssignmentService;
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


@Controller("AssignmentRestController")
public class AssignmentRestController {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping(value = "/Assignment", method = RequestMethod.PUT)
    @ResponseBody
    public Assignment saveAssignment(@RequestBody Assignment assignment) {
    assignmentService.saveAssignment(assignment);
        return assignmentRepository.findById(assignment.getId());
    }

    @RequestMapping(value = "/Assignment", method = RequestMethod.POST)
    @ResponseBody
    public Assignment newAssignment(@RequestBody Assignment assignment) {
    assignmentService.saveAssignment(assignment);
        return assignmentRepository.findById(assignment.getId());
    }

    @RequestMapping(value = "/Assignment", method = RequestMethod.GET)
    @ResponseBody
    public List<Assignment> listAssignments() {
        return new java.util.ArrayList<Assignment>(assignmentService.findAll());
    }

    @RequestMapping(value = "/Assignment/{assignment_id}", method = RequestMethod.GET)
    @ResponseBody
    public Assignment loadAssignment(@PathVariable Integer assignment_id) {
        return assignmentService.findById(assignment_id);
    }

    @RequestMapping(value = "/Assignment/Delete/{assignment_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteAssignment(@PathVariable Integer assignment_id) {
        return assignmentService.deleteAssignment(assignment_id);
    }
    @RequestMapping(value = "/Assignment/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Assignment> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (assignmentRepository.findAll(pageable));
    }

 @RequestMapping(value = "/Assignment/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Assignment> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (assignmentRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/Assignment/Module/{module_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Assignment> getAllByModuleId(@PathVariable("module_id") Integer moduleId) {
        return new java.util.ArrayList<Assignment>(assignmentService.findAllByModuleId(moduleId));
    }

}