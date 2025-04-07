package com.geneza.lms.service;
import com.geneza.lms.domain.Attendance;
import java.util.List;

public interface AttendanceService {
    public Attendance findById(Integer id);
    public void saveAttendance(Attendance attendance_1);
    public boolean deleteAttendance(Integer attendanceId);
    public List<Attendance> findAll();
    public List<Attendance> findAllByModuleId(Integer  module);
    public List<Attendance> findAllByEnrollmentId(Integer  enrollment);
    List<Attendance> findAllByBatchId(Integer batchId);

}