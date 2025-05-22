package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.Mentor;
import com.geneza.lms.persistence.MentorRepository;
import com.geneza.lms.service.MentorService;
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


@Controller("MentorRestController")
public class MentorRestController {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private MentorService mentorService;

    @RequestMapping(value = "/Mentor", method = RequestMethod.PUT)
    @ResponseBody
    public Mentor saveMentor(@RequestBody Mentor mentor) {
    mentorService.saveMentor(mentor);
        return mentorRepository.findById(mentor.getId());
    }

    @RequestMapping(value = "/Mentor", method = RequestMethod.POST)
    @ResponseBody
    public Mentor newMentor(@RequestBody Mentor mentor) {
    mentorService.saveMentor(mentor);
        return mentorRepository.findById(mentor.getId());
    }

    @RequestMapping(value = "/Mentor", method = RequestMethod.GET)
    @ResponseBody
    public List<Mentor> listMentors() {
        return new java.util.ArrayList<Mentor>(mentorService.findAll());
    }

    @RequestMapping(value = "/Mentor/{mentor_id}", method = RequestMethod.GET)
    @ResponseBody
    public Mentor loadMentor(@PathVariable Integer mentor_id) {
        return mentorService.findById(mentor_id);
    }

    @RequestMapping(value = "/Mentor/Delete/{mentor_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteMentor(@PathVariable Integer mentor_id) {
        return mentorService.deleteMentor(mentor_id);
    }

 @RequestMapping(value = "/Mentor/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Mentor> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (mentorRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/Mentor/Mentor/{mentor_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Mentor> getAllByMentorId(@PathVariable("mentor_id") Integer mentorId) {
        return new java.util.ArrayList<Mentor>(mentorService.findAllByMentorId(mentorId));
    }

}