package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.Attendance;
import com.geneza.lms.persistence.AttendanceRepository;
import com.geneza.lms.service.AttendanceService;
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


@Controller("AttendanceRestController")
public class AttendanceRestController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping(value = "/Attendance", method = RequestMethod.PUT)
    @ResponseBody
    public Attendance saveAttendance(@RequestBody Attendance attendance) {
    attendanceService.saveAttendance(attendance);
        return attendanceRepository.findById(attendance.getId());
    }

    @RequestMapping(value = "/Attendance", method = RequestMethod.POST)
    @ResponseBody
    public Attendance newAttendance(@RequestBody Attendance attendance) {
    attendanceService.saveAttendance(attendance);
        return attendanceRepository.findById(attendance.getId());
    }

    @RequestMapping(value = "/Attendance", method = RequestMethod.GET)
    @ResponseBody
    public List<Attendance> listAttendances() {
        return new java.util.ArrayList<Attendance>(attendanceService.findAll());
    }

    @RequestMapping(value = "/Attendance/{attendance_id}", method = RequestMethod.GET)
    @ResponseBody
    public Attendance loadAttendance(@PathVariable Integer attendance_id) {
        return attendanceService.findById(attendance_id);
    }

    @RequestMapping(value = "/Attendance/Delete/{attendance_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteAttendance(@PathVariable Integer attendance_id) {
        return attendanceService.deleteAttendance(attendance_id);
    }
    @RequestMapping(value = "/Attendance/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Attendance> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (attendanceRepository.findAll(pageable));
    }

 @RequestMapping(value = "/Attendance/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Attendance> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (attendanceRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/Attendance/Module/{module_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Attendance> getAllByModuleId(@PathVariable("module_id") Integer moduleId) {
        return new java.util.ArrayList<Attendance>(attendanceService.findAllByModuleId(moduleId));
    }

    @RequestMapping(value = "/Attendance/Enrollment/{enrollment_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Attendance> getAllByEnrollmentId(@PathVariable("enrollment_id") Integer enrollmentId) {
        return new java.util.ArrayList<Attendance>(attendanceService.findAllByEnrollmentId(enrollmentId));
    }

}