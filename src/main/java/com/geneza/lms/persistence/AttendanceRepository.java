package com.geneza.lms.persistence;  
import com.geneza.lms.domain.Attendance;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {	 
    Attendance findById(Integer id);
    List<Attendance> findAll();
    public List<Attendance> findAllByModuleId(Integer moduleId);
    public List<Attendance> findAllByEnrollmentId(Integer enrollmentId);  
   Page<Attendance> findAll(Pageable pageable);
   List<Attendance> findByEnrollment_Batch_Id(Integer batchId);

}