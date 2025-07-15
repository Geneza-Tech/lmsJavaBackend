package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.Module;
import com.geneza.lms.persistence.ModuleRepository;
import com.geneza.lms.service.ModuleService;
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


@Controller("ModuleRestController")
public class ModuleRestController {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value = "/Module", method = RequestMethod.PUT)
    @ResponseBody
    public Module saveModule(@RequestBody Module module) {
    moduleService.saveModule(module);
        return moduleRepository.findById(module.getId());
    }

    @RequestMapping(value = "/Module", method = RequestMethod.POST)
    @ResponseBody
    public Module newModule(@RequestBody Module module) {
    moduleService.saveModule(module);
        return moduleRepository.findById(module.getId());
    }

    @RequestMapping(value = "/Module", method = RequestMethod.GET)
    @ResponseBody
    public List<Module> listModules() {
        return new java.util.ArrayList<Module>(moduleService.findAll());
    }

    @RequestMapping(value = "/Module/{module_id}", method = RequestMethod.GET)
    @ResponseBody
    public Module loadModule(@PathVariable Integer module_id) {
        return moduleService.findById(module_id);
    }

    @RequestMapping(value = "/Module/Delete/{module_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteModule(@PathVariable Integer module_id) {
        return moduleService.deleteModule(module_id);
    }
    @RequestMapping(value = "/Module/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Module> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (moduleRepository.findAll(pageable));
    }

 @RequestMapping(value = "/Module/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Module> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (moduleRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/Module/Course/{course_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Module> getAllByCourseId(@PathVariable("course_id") Integer courseId) {
        return new java.util.ArrayList<Module>(moduleService.findAllByCourseId(courseId));
    }

}