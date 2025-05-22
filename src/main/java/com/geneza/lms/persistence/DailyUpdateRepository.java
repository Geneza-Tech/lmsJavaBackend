package com.geneza.lms.persistence;  
import com.geneza.lms.domain.DailyUpdate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface DailyUpdateRepository extends JpaRepository<DailyUpdate, Long> {	 
    DailyUpdate findById(Integer id);
    List<DailyUpdate> findAll();
    public List<DailyUpdate> findAllByBatchId(Integer batchId);  
   Page<DailyUpdate> findAll(Pageable pageable);

}