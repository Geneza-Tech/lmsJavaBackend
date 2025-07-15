package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.CourseSurvey;
import com.geneza.lms.persistence.CourseSurveyRepository;
import com.geneza.lms.service.CourseSurveyService;
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


@Controller("CourseSurveyRestController")
public class CourseSurveyRestController {

    @Autowired
    private CourseSurveyRepository courseSurveyRepository;

    @Autowired
    private CourseSurveyService courseSurveyService;

    @RequestMapping(value = "/CourseSurvey", method = RequestMethod.PUT)
    @ResponseBody
    public CourseSurvey saveCourseSurvey(@RequestBody CourseSurvey courseSurvey) {
    courseSurveyService.saveCourseSurvey(courseSurvey);
        return courseSurveyRepository.findById(courseSurvey.getId());
    }

    @RequestMapping(value = "/CourseSurvey", method = RequestMethod.POST)
    @ResponseBody
    public CourseSurvey newCourseSurvey(@RequestBody CourseSurvey courseSurvey) {
    courseSurveyService.saveCourseSurvey(courseSurvey);
        return courseSurveyRepository.findById(courseSurvey.getId());
    }

    @RequestMapping(value = "/CourseSurvey", method = RequestMethod.GET)
    @ResponseBody
    public List<CourseSurvey> listCourseSurveys() {
        return new java.util.ArrayList<CourseSurvey>(courseSurveyService.findAll());
    }

    @RequestMapping(value = "/CourseSurvey/{courseSurvey_id}", method = RequestMethod.GET)
    @ResponseBody
    public CourseSurvey loadCourseSurvey(@PathVariable Integer courseSurvey_id) {
        return courseSurveyService.findById(courseSurvey_id);
    }

    @RequestMapping(value = "/CourseSurvey/Delete/{courseSurvey_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteCourseSurvey(@PathVariable Integer courseSurvey_id) {
        return courseSurveyService.deleteCourseSurvey(courseSurvey_id);
    }

 @RequestMapping(value = "/CourseSurvey/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<CourseSurvey> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (courseSurveyRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/CourseSurvey/Course/{course_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<CourseSurvey> getAllByCourseId(@PathVariable("course_id") Integer courseId) {
        return new java.util.ArrayList<CourseSurvey>(courseSurveyService.findAllByCourseId(courseId));
    }

}