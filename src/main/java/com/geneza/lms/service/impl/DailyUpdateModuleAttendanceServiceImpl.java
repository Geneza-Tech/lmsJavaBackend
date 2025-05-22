package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.DailyUpdateModuleAttendanceRepository;
import com.geneza.lms.domain.DailyUpdateModuleAttendance;
import com.geneza.lms.service.DailyUpdateModuleAttendanceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("DailyUpdateModuleAttendanceService")
@Transactional
public class DailyUpdateModuleAttendanceServiceImpl implements DailyUpdateModuleAttendanceService {

    @Autowired
    private DailyUpdateModuleAttendanceRepository dailyUpdateModuleAttendanceRepository;
    public DailyUpdateModuleAttendanceServiceImpl() {
    }

    @Transactional
    public DailyUpdateModuleAttendance findById(Integer id) {
        return dailyUpdateModuleAttendanceRepository.findById(id);
    }

    @Transactional
    public List<DailyUpdateModuleAttendance> findAll() {
        return dailyUpdateModuleAttendanceRepository.findAll();
    }
     
    @Transactional
    public void saveDailyUpdateModuleAttendance(DailyUpdateModuleAttendance dailyUpdateModuleAttendance) {
        DailyUpdateModuleAttendance existingDailyUpdateModuleAttendance = dailyUpdateModuleAttendanceRepository.findById(dailyUpdateModuleAttendance.getId());
        if (existingDailyUpdateModuleAttendance != null) {
        if (existingDailyUpdateModuleAttendance != dailyUpdateModuleAttendance) {      
        existingDailyUpdateModuleAttendance.setId(dailyUpdateModuleAttendance.getId());
                existingDailyUpdateModuleAttendance.setDailyUpdateModule(dailyUpdateModuleAttendance.getDailyUpdateModule());
                existingDailyUpdateModuleAttendance.setEnrollment(dailyUpdateModuleAttendance.getEnrollment());
                existingDailyUpdateModuleAttendance.setAttendance(dailyUpdateModuleAttendance.getAttendance());
        }
        dailyUpdateModuleAttendance = dailyUpdateModuleAttendanceRepository.save(existingDailyUpdateModuleAttendance);
    }else{
        dailyUpdateModuleAttendance = dailyUpdateModuleAttendanceRepository.save(dailyUpdateModuleAttendance);
        }
        dailyUpdateModuleAttendanceRepository.flush();
    }

    public boolean deleteDailyUpdateModuleAttendance(Integer dailyUpdateModuleAttendanceId) {
        DailyUpdateModuleAttendance dailyUpdateModuleAttendance = dailyUpdateModuleAttendanceRepository.findById(dailyUpdateModuleAttendanceId);
        if(dailyUpdateModuleAttendance!=null) {
            dailyUpdateModuleAttendanceRepository.delete(dailyUpdateModuleAttendance);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<DailyUpdateModuleAttendance> findAllByDailyUpdateModuleId(Integer  dailyUpdateModuleId) {
        return new java.util.ArrayList<DailyUpdateModuleAttendance>(dailyUpdateModuleAttendanceRepository.findAllByDailyUpdateModuleId(dailyUpdateModuleId));
    }@Transactional
    public List<DailyUpdateModuleAttendance> findAllByEnrollmentId(Integer  enrollmentId) {
        return new java.util.ArrayList<DailyUpdateModuleAttendance>(dailyUpdateModuleAttendanceRepository.findAllByEnrollmentId(enrollmentId));
    }

    @Override
public List<DailyUpdateModuleAttendance> findAllByDailyUpdateId(Integer dailyUpdateId) {
    return dailyUpdateModuleAttendanceRepository.findByDailyUpdateModule_DailyUpdate_Id(dailyUpdateId);
}

@Override
public List<DailyUpdateModuleAttendance> findAllByBatchModuleId(Integer batchModuleId) {
    return dailyUpdateModuleAttendanceRepository.findByDailyUpdateModule_Module_Id(batchModuleId);
}



}