package com.geneza.lms.service;
import com.geneza.lms.domain.DailyUpdateModuleAttendance;
import java.util.List;

public interface DailyUpdateModuleAttendanceService {
    public DailyUpdateModuleAttendance findById(Integer id);
    public void saveDailyUpdateModuleAttendance(DailyUpdateModuleAttendance dailyUpdateModuleAttendance_1);
    public boolean deleteDailyUpdateModuleAttendance(Integer dailyUpdateModuleAttendanceId);
    public List<DailyUpdateModuleAttendance> findAll();
    public List<DailyUpdateModuleAttendance> findAllByDailyUpdateModuleId(Integer  dailyUpdateModule);
    public List<DailyUpdateModuleAttendance> findAllByEnrollmentId(Integer  enrollment);
    List<DailyUpdateModuleAttendance> findAllByDailyUpdateId(Integer dailyUpdateId);
    List<DailyUpdateModuleAttendance> findAllByBatchModuleId(Integer batchModuleId);

}