package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.Course;
import com.geneza.lms.persistence.CourseRepository;
import com.geneza.lms.service.CourseService;
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


@Controller("CourseRestController")
public class CourseRestController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/Course", method = RequestMethod.PUT)
    @ResponseBody
    public Course saveCourse(@RequestBody Course course) {
    courseService.saveCourse(course);
        return courseRepository.findById(course.getId());
    }

    @RequestMapping(value = "/Course", method = RequestMethod.POST)
    @ResponseBody
    public Course newCourse(@RequestBody Course course) {
    courseService.saveCourse(course);
        return courseRepository.findById(course.getId());
    }

    @RequestMapping(value = "/Course", method = RequestMethod.GET)
    @ResponseBody
    public List<Course> listCourses() {
        return new java.util.ArrayList<Course>(courseService.findAll());
    }

    @RequestMapping(value = "/Course/{course_id}", method = RequestMethod.GET)
    @ResponseBody
    public Course loadCourse(@PathVariable Integer course_id) {
        return courseService.findById(course_id);
    }

    @RequestMapping(value = "/Course/Delete/{course_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteCourse(@PathVariable Integer course_id) {
        return courseService.deleteCourse(course_id);
    }
    @RequestMapping(value = "/Course/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Course> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (courseRepository.findAll(pageable));
    }

 @RequestMapping(value = "/Course/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Course> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (courseRepository.findAll(sortedPaged));
    }


}