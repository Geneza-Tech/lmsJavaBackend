package com.geneza.lms.service.impl;

import com.geneza.lms.service.SessionAttendanceService;
import com.geneza.lms.domain.Enrollment;
import com.geneza.lms.domain.Session;
import com.geneza.lms.domain.SessionAttendance;
import com.geneza.lms.dto.AttendanceRequest;
import com.geneza.lms.persistence.SessionAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SessionAttendanceServiceImpl implements SessionAttendanceService {

    @Autowired
    private SessionAttendanceRepository attendanceRepository;

    @Override
    public SessionAttendance save(SessionAttendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public SessionAttendance findById(Integer id) {
        return attendanceRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Attendance not found with ID: " + id));
    }

    @Override
    public List<SessionAttendance> findAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public Page<SessionAttendance> findAll(Pageable pageable) {
        return attendanceRepository.findAll(pageable);
    }

    @Override
    public List<SessionAttendance> findAllBySessionId(Integer sessionId) {
        return attendanceRepository.findAllBySessionId(sessionId);
    }

    @Override
    public List<SessionAttendance> findAllByEnrollmentId(Integer enrollmentId) {
        return attendanceRepository.findAllByEnrollmentId(enrollmentId);
    }

    @Override
    public List<SessionAttendance> findAllBySessionIdAndEnrollmentId(Integer sessionId, Integer enrollmentId) {
        return attendanceRepository.findAllBySessionIdAndEnrollmentId(sessionId, enrollmentId);
    }

    @Override
    public boolean  deleteById(Integer id) {
        if (attendanceRepository.existsById(id)) {
        attendanceRepository.deleteById(id);
        return true;
    } else {
        return false;
    }
    }

    @Override
public List<SessionAttendance> findAllByBatchId(Integer batchId) {
    return attendanceRepository.findBySession_Batch_Id(batchId);
}

   @Override
public List<SessionAttendance> bulkMarkAttendance(Integer sessionId, List<AttendanceRequest> requests) {

    List<SessionAttendance> existingList = attendanceRepository.findAllBySessionId(sessionId);

    Map<Integer, SessionAttendance> existingMap = existingList.stream()
            .collect(Collectors.toMap(
                    a -> a.getEnrollment().getId(),
                    a -> a
            ));

    List<SessionAttendance> toSave = new ArrayList<>();

    for (AttendanceRequest req : requests) {

        if (existingMap.containsKey(req.getEnrollmentId())) {

            SessionAttendance existing = existingMap.get(req.getEnrollmentId());
            existing.setAttendance(req.isAttendance());
            toSave.add(existing);

        } else {

            SessionAttendance newAttendance = new SessionAttendance();

            Session session = new Session();
            session.setId(sessionId);

            Enrollment enrollment = new Enrollment();
            enrollment.setId(req.getEnrollmentId());

            newAttendance.setSession(session);
            newAttendance.setEnrollment(enrollment);
            newAttendance.setAttendance(req.isAttendance());

            toSave.add(newAttendance);
        }
    }

    return attendanceRepository.saveAll(toSave);
}

}
