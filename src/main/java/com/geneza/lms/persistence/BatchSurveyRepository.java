package com.geneza.lms.persistence;  
import com.geneza.lms.domain.BatchSurvey;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface BatchSurveyRepository extends JpaRepository<BatchSurvey, Long> {	 
    BatchSurvey findById(Integer id);
    List<BatchSurvey> findAll();
    public List<BatchSurvey> findAllByBatchId(Integer batchId);  
   Page<BatchSurvey> findAll(Pageable pageable);

}