package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.DailyUpdateModuleAttendance;
import com.geneza.lms.persistence.DailyUpdateModuleAttendanceRepository;
import com.geneza.lms.service.DailyUpdateModuleAttendanceService;
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


@Controller("DailyUpdateModuleAttendanceRestController")
public class DailyUpdateModuleAttendanceRestController {

    @Autowired
    private DailyUpdateModuleAttendanceRepository dailyUpdateModuleAttendanceRepository;

    @Autowired
    private DailyUpdateModuleAttendanceService dailyUpdateModuleAttendanceService;

    @RequestMapping(value = "/DailyUpdateModuleAttendance", method = RequestMethod.PUT)
    @ResponseBody
    public DailyUpdateModuleAttendance saveDailyUpdateModuleAttendance(@RequestBody DailyUpdateModuleAttendance dailyUpdateModuleAttendance) {
    dailyUpdateModuleAttendanceService.saveDailyUpdateModuleAttendance(dailyUpdateModuleAttendance);
        return dailyUpdateModuleAttendanceRepository.findById(dailyUpdateModuleAttendance.getId());
    }

    @RequestMapping(value = "/DailyUpdateModuleAttendance", method = RequestMethod.POST)
    @ResponseBody
    public DailyUpdateModuleAttendance newDailyUpdateModuleAttendance(@RequestBody DailyUpdateModuleAttendance dailyUpdateModuleAttendance) {
    dailyUpdateModuleAttendanceService.saveDailyUpdateModuleAttendance(dailyUpdateModuleAttendance);
        return dailyUpdateModuleAttendanceRepository.findById(dailyUpdateModuleAttendance.getId());
    }

    @RequestMapping(value = "/DailyUpdateModuleAttendance", method = RequestMethod.GET)
    @ResponseBody
    public List<DailyUpdateModuleAttendance> listDailyUpdateModuleAttendances() {
        return new java.util.ArrayList<DailyUpdateModuleAttendance>(dailyUpdateModuleAttendanceService.findAll());
    }

    @RequestMapping(value = "/DailyUpdateModuleAttendance/{dailyUpdateModuleAttendance_id}", method = RequestMethod.GET)
    @ResponseBody
    public DailyUpdateModuleAttendance loadDailyUpdateModuleAttendance(@PathVariable Integer dailyUpdateModuleAttendance_id) {
        return dailyUpdateModuleAttendanceService.findById(dailyUpdateModuleAttendance_id);
    }

    @RequestMapping(value = "/DailyUpdateModuleAttendance/Delete/{dailyUpdateModuleAttendance_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteDailyUpdateModuleAttendance(@PathVariable Integer dailyUpdateModuleAttendance_id) {
        return dailyUpdateModuleAttendanceService.deleteDailyUpdateModuleAttendance(dailyUpdateModuleAttendance_id);
    }

 @RequestMapping(value = "/DailyUpdateModuleAttendance/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<DailyUpdateModuleAttendance> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (dailyUpdateModuleAttendanceRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/DailyUpdateModuleAttendance/DailyUpdateModule/{dailyUpdateModule_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<DailyUpdateModuleAttendance> getAllByDailyUpdateModuleId(@PathVariable("dailyUpdateModule_id") Integer dailyUpdateModuleId) {
        return new java.util.ArrayList<DailyUpdateModuleAttendance>(dailyUpdateModuleAttendanceService.findAllByDailyUpdateModuleId(dailyUpdateModuleId));
    }

    @RequestMapping(value = "/DailyUpdateModuleAttendance/Enrollment/{enrollment_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<DailyUpdateModuleAttendance> getAllByEnrollmentId(@PathVariable("enrollment_id") Integer enrollmentId) {
        return new java.util.ArrayList<DailyUpdateModuleAttendance>(dailyUpdateModuleAttendanceService.findAllByEnrollmentId(enrollmentId));
    }

    @RequestMapping(value = "/DailyUpdateModuleAttendance/DailyUpdate/{dailyUpdate_id}", method = RequestMethod.GET)
@ResponseBody
public List<DailyUpdateModuleAttendance> getAllByDailyUpdateId(@PathVariable("dailyUpdate_id") Integer dailyUpdateId) {
    return dailyUpdateModuleAttendanceService.findAllByDailyUpdateId(dailyUpdateId);
}

@RequestMapping(value = "/DailyUpdateModuleAttendance/BatchModule/{batchModule_id}", method = RequestMethod.GET)
@ResponseBody
public List<DailyUpdateModuleAttendance> getAllByBatchModuleId(@PathVariable("batchModule_id") Integer batchModuleId) {
    return dailyUpdateModuleAttendanceService.findAllByBatchModuleId(batchModuleId);
}



}