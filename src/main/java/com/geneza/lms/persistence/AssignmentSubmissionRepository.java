package com.geneza.lms.persistence;  
import com.geneza.lms.domain.AssignmentSubmission;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
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

}