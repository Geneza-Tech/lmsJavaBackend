package com.geneza.lms.persistence;  
import com.geneza.lms.domain.AssignmentSubmission;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface AssignmentSubmissionRepository extends JpaRepository<AssignmentSubmission, Long> {	 
    AssignmentSubmission findById(Integer id);
    List<AssignmentSubmission> findAll();
    public List<AssignmentSubmission> findAllByAssignmentId(Integer assignmentId);
    public List<AssignmentSubmission> findAllByEnrollmentId(Integer enrollmentId);
    public List<AssignmentSubmission> findAllBySubmissionStatusId(Integer submissionStatusId);  
   Page<AssignmentSubmission> findAll(Pageable pageable);

   @Query("SELECT a FROM AssignmentSubmission a WHERE a.enrollment.student.id = :personId")
List<AssignmentSubmission> findByPersonId(@Param("personId") Integer personId);

@Query("SELECT s FROM AssignmentSubmission s " +
       "JOIN s.assignment a " +
       "JOIN a.module m " +
       "JOIN s.enrollment e " +
       "JOIN e.batch b " +
       "WHERE b.id = :batchId " +
       "AND (:moduleId IS NULL OR m.id = :moduleId) " +
       "AND (:studentName IS NULL OR :studentName = '' OR " +
       "LOWER(CONCAT(e.student.firstName, ' ', e.student.lastName)) " +
       "LIKE LOWER(CONCAT('%', :studentName, '%'))) ")
List<AssignmentSubmission> findByBatchAndOptionalModuleAndStudent(
        @Param("batchId") Integer batchId,
        @Param("moduleId") Integer moduleId,
        @Param("studentName") String studentName);









}