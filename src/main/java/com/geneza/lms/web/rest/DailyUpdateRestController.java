package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.DailyUpdate;
import com.geneza.lms.persistence.DailyUpdateRepository;
import com.geneza.lms.service.DailyUpdateService;
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


@Controller("DailyUpdateRestController")
public class DailyUpdateRestController {

    @Autowired
    private DailyUpdateRepository dailyUpdateRepository;

    @Autowired
    private DailyUpdateService dailyUpdateService;

    @RequestMapping(value = "/DailyUpdate", method = RequestMethod.PUT)
    @ResponseBody
    public DailyUpdate saveDailyUpdate(@RequestBody DailyUpdate dailyUpdate) {
    dailyUpdateService.saveDailyUpdate(dailyUpdate);
        return dailyUpdateRepository.findById(dailyUpdate.getId());
    }

    @RequestMapping(value = "/DailyUpdate", method = RequestMethod.POST)
    @ResponseBody
    public DailyUpdate newDailyUpdate(@RequestBody DailyUpdate dailyUpdate) {
    dailyUpdateService.saveDailyUpdate(dailyUpdate);
        return dailyUpdateRepository.findById(dailyUpdate.getId());
    }

    @RequestMapping(value = "/DailyUpdate", method = RequestMethod.GET)
    @ResponseBody
    public List<DailyUpdate> listDailyUpdates() {
        return new java.util.ArrayList<DailyUpdate>(dailyUpdateService.findAll());
    }

    @RequestMapping(value = "/DailyUpdate/{dailyUpdate_id}", method = RequestMethod.GET)
    @ResponseBody
    public DailyUpdate loadDailyUpdate(@PathVariable Integer dailyUpdate_id) {
        return dailyUpdateService.findById(dailyUpdate_id);
    }

    @RequestMapping(value = "/DailyUpdate/Delete/{dailyUpdate_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteDailyUpdate(@PathVariable Integer dailyUpdate_id) {
        return dailyUpdateService.deleteDailyUpdate(dailyUpdate_id);
    }

 @RequestMapping(value = "/DailyUpdate/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<DailyUpdate> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (dailyUpdateRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/DailyUpdate/Batch/{batch_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<DailyUpdate> getAllByBatchId(@PathVariable("batch_id") Integer batchId) {
        return new java.util.ArrayList<DailyUpdate>(dailyUpdateService.findAllByBatchId(batchId));
    }

}