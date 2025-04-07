package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.AttendanceRepository;
import com.geneza.lms.domain.Attendance;
import com.geneza.lms.service.AttendanceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AttendanceService")
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;
    public AttendanceServiceImpl() {
    }

    @Transactional
    public Attendance findById(Integer id) {
        return attendanceRepository.findById(id);
    }

    @Transactional
    public List<Attendance> findAll() {
        return attendanceRepository.findAll();
    }
     
    @Transactional
    public void saveAttendance(Attendance attendance) {
        Attendance existingAttendance = attendanceRepository.findById(attendance.getId());
        if (existingAttendance != null) {
        if (existingAttendance != attendance) {      
        existingAttendance.setId(attendance.getId());
                existingAttendance.setModule(attendance.getModule());
                existingAttendance.setEnrollment(attendance.getEnrollment());
                existingAttendance.setIsPresent(attendance.getIsPresent());
        }
        attendance = attendanceRepository.save(existingAttendance);
    }else{
        attendance = attendanceRepository.save(attendance);
        }
        attendanceRepository.flush();
    }

    public boolean deleteAttendance(Integer attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId);
        if(attendance!=null) {
            attendanceRepository.delete(attendance);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<Attendance> findAllByModuleId(Integer  moduleId) {
        return new java.util.ArrayList<Attendance>(attendanceRepository.findAllByModuleId(moduleId));
    }@Transactional
    public List<Attendance> findAllByEnrollmentId(Integer  enrollmentId) {
        return new java.util.ArrayList<Attendance>(attendanceRepository.findAllByEnrollmentId(enrollmentId));
    }

    @Override
public List<Attendance> findAllByBatchId(Integer batchId) {
    return attendanceRepository.findByEnrollment_Batch_Id(batchId);
}


}