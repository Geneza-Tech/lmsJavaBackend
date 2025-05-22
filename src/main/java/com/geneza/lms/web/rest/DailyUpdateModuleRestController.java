package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.DailyUpdateModule;
import com.geneza.lms.persistence.DailyUpdateModuleRepository;
import com.geneza.lms.service.DailyUpdateModuleService;
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


@Controller("DailyUpdateModuleRestController")
public class DailyUpdateModuleRestController {

    @Autowired
    private DailyUpdateModuleRepository dailyUpdateModuleRepository;

    @Autowired
    private DailyUpdateModuleService dailyUpdateModuleService;

    @RequestMapping(value = "/DailyUpdateModule", method = RequestMethod.PUT)
    @ResponseBody
    public DailyUpdateModule saveDailyUpdateModule(@RequestBody DailyUpdateModule dailyUpdateModule) {
    dailyUpdateModuleService.saveDailyUpdateModule(dailyUpdateModule);
        return dailyUpdateModuleRepository.findById(dailyUpdateModule.getId());
    }

    @RequestMapping(value = "/DailyUpdateModule", method = RequestMethod.POST)
    @ResponseBody
    public DailyUpdateModule newDailyUpdateModule(@RequestBody DailyUpdateModule dailyUpdateModule) {
    dailyUpdateModuleService.saveDailyUpdateModule(dailyUpdateModule);
        return dailyUpdateModuleRepository.findById(dailyUpdateModule.getId());
    }

    @RequestMapping(value = "/DailyUpdateModule", method = RequestMethod.GET)
    @ResponseBody
    public List<DailyUpdateModule> listDailyUpdateModules() {
        return new java.util.ArrayList<DailyUpdateModule>(dailyUpdateModuleService.findAll());
    }

    @RequestMapping(value = "/DailyUpdateModule/{dailyUpdateModule_id}", method = RequestMethod.GET)
    @ResponseBody
    public DailyUpdateModule loadDailyUpdateModule(@PathVariable Integer dailyUpdateModule_id) {
        return dailyUpdateModuleService.findById(dailyUpdateModule_id);
    }

    @RequestMapping(value = "/DailyUpdateModule/Delete/{dailyUpdateModule_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteDailyUpdateModule(@PathVariable Integer dailyUpdateModule_id) {
        return dailyUpdateModuleService.deleteDailyUpdateModule(dailyUpdateModule_id);
    }

 @RequestMapping(value = "/DailyUpdateModule/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<DailyUpdateModule> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (dailyUpdateModuleRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/DailyUpdateModule/DailyUpdate/{dailyUpdate_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<DailyUpdateModule> getAllByDailyUpdateId(@PathVariable("dailyUpdate_id") Integer dailyUpdateId) {
        return new java.util.ArrayList<DailyUpdateModule>(dailyUpdateModuleService.findAllByDailyUpdateId(dailyUpdateId));
    }

    @RequestMapping(value = "/DailyUpdateModule/Module/{module_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<DailyUpdateModule> getAllByModuleId(@PathVariable("module_id") Integer moduleId) {
        return new java.util.ArrayList<DailyUpdateModule>(dailyUpdateModuleService.findAllByModuleId(moduleId));
    }

}