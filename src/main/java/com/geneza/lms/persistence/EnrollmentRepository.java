package com.geneza.lms.persistence;  
import com.geneza.lms.domain.Batch;
import com.geneza.lms.domain.Enrollment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {	 
    Enrollment findById(Integer id);
    List<Enrollment> findAll();
    public List<Enrollment> findAllByBatchId(Integer batchId);
    public List<Enrollment> findAllByStudentId(Integer studentId);  
   Page<Enrollment> findAll(Pageable pageable);
   Page<Enrollment> findByBatchId(Integer batchId, Pageable pageable);
   @Query("SELECT e.batch FROM Enrollment e WHERE e.student.id = :studentId")
    List<Batch> findBatchesByStudentId(@Param("studentId") Integer studentId);

}