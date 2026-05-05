package com.geneza.lms.persistence;  
import com.geneza.lms.domain.Assignment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {	 
    Assignment findById(Integer id);
    List<Assignment> findAll();
    public List<Assignment> findAllByModuleId(Integer moduleId);  
   Page<Assignment> findAll(Pageable pageable);
       @Query("SELECT DISTINCT a FROM Assignment a " +
       "JOIN a.module m " +
       "JOIN BatchModule bm ON bm.module = m " +
       "JOIN Enrollment e ON e.batch = bm.batch " +
       "WHERE e.student.id = :personId")
List<Assignment> findAssignmentsByPersonId(@Param("personId") Integer personId);

    @Query("SELECT a FROM Assignment a WHERE a.module.id IN " +
       "(SELECT bm.module.id FROM BatchModule bm WHERE bm.batch.id = :batchId)")
List<Assignment> findAssignmentsByBatchId(@Param("batchId") Integer batchId);


}