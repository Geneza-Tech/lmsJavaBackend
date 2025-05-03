package com.geneza.lms.persistence;  
import com.geneza.lms.domain.Assignment;
import com.geneza.lms.domain.AssignmentSubmission;
import com.geneza.lms.domain.Enrollment;

import java.util.List;
import java.util.Optional;

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
       "WHERE (:batchId IS NULL OR b.id = :batchId) " +
       "AND (:moduleId IS NULL OR m.id = :moduleId) " +
       "AND (:studentId IS NULL OR e.student.id = :studentId) ")
List<AssignmentSubmission> findByBatchAndOptionalModuleAndStudent(
        @Param("batchId") Integer batchId,
        @Param("moduleId") Integer moduleId,
        @Param("studentId") Integer studentId);



 Optional<AssignmentSubmission> findByAssignmentAndEnrollment(Assignment assignment, Enrollment enrollment);





}