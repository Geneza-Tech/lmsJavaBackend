package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.Enrollment;
import com.geneza.lms.persistence.EnrollmentRepository;
import com.geneza.lms.service.EnrollmentService;
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


@Controller("EnrollmentRestController")
public class EnrollmentRestController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private EnrollmentService enrollmentService;

    @RequestMapping(value = "/Enrollment", method = RequestMethod.PUT)
    @ResponseBody
    public Enrollment saveEnrollment(@RequestBody Enrollment enrollment) {
    enrollmentService.saveEnrollment(enrollment);
        return enrollmentRepository.findById(enrollment.getId());
    }

    @RequestMapping(value = "/Enrollment", method = RequestMethod.POST)
    @ResponseBody
    public Enrollment newEnrollment(@RequestBody Enrollment enrollment) {
    enrollmentService.saveEnrollment(enrollment);
        return enrollmentRepository.findById(enrollment.getId());
    }

    @RequestMapping(value = "/Enrollment", method = RequestMethod.GET)
    @ResponseBody
    public List<Enrollment> listEnrollments() {
        return new java.util.ArrayList<Enrollment>(enrollmentService.findAll());
    }

    @RequestMapping(value = "/Enrollment/{enrollment_id}", method = RequestMethod.GET)
    @ResponseBody
    public Enrollment loadEnrollment(@PathVariable Integer enrollment_id) {
        return enrollmentService.findById(enrollment_id);
    }

    @RequestMapping(value = "/Enrollment/Delete/{enrollment_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteEnrollment(@PathVariable Integer enrollment_id) {
        return enrollmentService.deleteEnrollment(enrollment_id);
    }
    @RequestMapping(value = "/Enrollment/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Enrollment> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (enrollmentRepository.findAll(pageable));
    }

 @RequestMapping(value = "/Enrollment/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Enrollment> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (enrollmentRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/Enrollment/Batch/{batch_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Enrollment> getAllByBatchId(@PathVariable("batch_id") Integer batchId) {
        return new java.util.ArrayList<Enrollment>(enrollmentService.findAllByBatchId(batchId));
    }

    @RequestMapping(value = "/Enrollment/Student/{student_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Enrollment> getAllByStudentId(@PathVariable("student_id") Integer studentId) {
        return new java.util.ArrayList<Enrollment>(enrollmentService.findAllByStudentId(studentId));
    }

}