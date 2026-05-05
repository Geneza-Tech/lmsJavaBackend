package com.geneza.lms.service;

import com.geneza.lms.domain.SessionAttendance;
import com.geneza.lms.dto.AttendanceRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SessionAttendanceService {
    SessionAttendance save(SessionAttendance attendance);
    SessionAttendance findById(Integer id);
    List<SessionAttendance> findAll();
    Page<SessionAttendance> findAll(Pageable pageable);
    List<SessionAttendance> findAllBySessionId(Integer sessionId);
    List<SessionAttendance> findAllByEnrollmentId(Integer enrollmentId);
    List<SessionAttendance> findAllBySessionIdAndEnrollmentId(Integer sessionId, Integer enrollmentId);
    boolean deleteById(Integer id);
    List<SessionAttendance> findAllByBatchId(Integer batchId);
    List<SessionAttendance> bulkMarkAttendance(Integer sessionId, List<AttendanceRequest> requests);

}
