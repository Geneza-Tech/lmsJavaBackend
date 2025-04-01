package com.geneza.lms.persistence;  
import com.geneza.lms.domain.SubmissionStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface SubmissionStatusRepository extends JpaRepository<SubmissionStatus, Long> {	 
    SubmissionStatus findById(Integer id);
    List<SubmissionStatus> findAll();  
   Page<SubmissionStatus> findAll(Pageable pageable);

}