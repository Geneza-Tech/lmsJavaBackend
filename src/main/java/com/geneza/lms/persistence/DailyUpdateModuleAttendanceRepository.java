package com.geneza.lms.persistence;  
import com.geneza.lms.domain.DailyUpdateModuleAttendance;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface DailyUpdateModuleAttendanceRepository extends JpaRepository<DailyUpdateModuleAttendance, Long> {	 
    DailyUpdateModuleAttendance findById(Integer id);
    List<DailyUpdateModuleAttendance> findAll();
    public List<DailyUpdateModuleAttendance> findAllByDailyUpdateModuleId(Integer dailyUpdateModuleId);
    public List<DailyUpdateModuleAttendance> findAllByEnrollmentId(Integer enrollmentId);  
   Page<DailyUpdateModuleAttendance> findAll(Pageable pageable);
   List<DailyUpdateModuleAttendance> findByDailyUpdateModule_DailyUpdate_Id(Integer dailyUpdateId);
    List<DailyUpdateModuleAttendance> findByDailyUpdateModule_Module_Id(Integer batchModuleId);
}