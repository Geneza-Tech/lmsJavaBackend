package com.geneza.lms.web.rest;

import com.geneza.lms.domain.SessionAttendance;
import com.geneza.lms.dto.AttendanceRequest;
import com.geneza.lms.persistence.SessionAttendanceRepository;
import com.geneza.lms.service.SessionAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.PageRequest;
import java.util.List;


@Controller("SessionAttendanceRestController")
public class SessionAttendanceRestController {

    @Autowired
    private SessionAttendanceService attendanceService;

    @Autowired
    private SessionAttendanceRepository attendanceRepository;

    @RequestMapping(value = "/SessionAttendance", method = RequestMethod.POST)
    @ResponseBody
    public SessionAttendance createAttendance(@RequestBody SessionAttendance attendance) {
        attendanceService.save(attendance);
        return attendanceRepository.findById(attendance.getId()).orElse(null);
    }

    @RequestMapping(value = "/SessionAttendance/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SessionAttendance getById(@PathVariable Integer id) {
        return attendanceService.findById(id);
    }

    @RequestMapping(value = "/SessionAttendance", method = RequestMethod.GET)
    @ResponseBody
    public List<SessionAttendance> getAll() {
        return attendanceService.findAll();
    }

    @RequestMapping(value = "/SessionAttendance/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<SessionAttendance> getPaged(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Direction.DESC, "id"));
        return attendanceService.findAll(pageable);
    }

    @RequestMapping(value = "/SessionAttendance/Session/{sessionId}", method = RequestMethod.GET)
    @ResponseBody
    public List<SessionAttendance> getBySessionId(@PathVariable Integer sessionId) {
        return attendanceService.findAllBySessionId(sessionId);
    }

    @RequestMapping(value = "/SessionAttendance/Enrollment/{enrollmentId}", method = RequestMethod.GET)
    @ResponseBody
    public List<SessionAttendance> getByEnrollmentId(@PathVariable Integer enrollmentId) {
        return attendanceService.findAllByEnrollmentId(enrollmentId);
    }

    @RequestMapping(value = "/SessionAttendance/Session/{sessionId}/Enrollment/{enrollmentId}", method = RequestMethod.GET)
    @ResponseBody
    public List<SessionAttendance> getBySessionAndEnrollment(@PathVariable Integer sessionId, @PathVariable Integer enrollmentId) {
        return attendanceService.findAllBySessionIdAndEnrollmentId(sessionId, enrollmentId);
    }

    @RequestMapping(value = "/SessionAttendance/Delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteAttendance(@PathVariable Integer id) {
        return attendanceService.deleteById(id);
    }

    @RequestMapping(value = "/SessionAttendance/Batch/{batchId}", method = RequestMethod.GET)
@ResponseBody
public List<SessionAttendance> getByBatchId(@PathVariable Integer batchId) {
    return attendanceService.findAllByBatchId(batchId);
}   

    @RequestMapping(value = "/SessionAttendance", method = RequestMethod.PUT)
@ResponseBody
public SessionAttendance updateAttendance(@RequestBody SessionAttendance attendance) {
    attendanceService.save(attendance); // Save updated data
    return attendanceRepository.findById(attendance.getId()).orElse(null); // Return the updated object
}

@PostMapping("/sessions/{sessionId}/attendance/bulk")
public ResponseEntity<List<SessionAttendance>> markAttendance(
        @PathVariable Integer sessionId,
        @RequestBody List<AttendanceRequest> requests) {

    return ResponseEntity.ok(
        attendanceService.bulkMarkAttendance(sessionId, requests)
    );
}


}
