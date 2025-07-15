package com.geneza.lms.persistence;  
import com.geneza.lms.domain.BatchTrainer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface BatchTrainerRepository extends JpaRepository<BatchTrainer, Long> {	 
    BatchTrainer findById(Integer id);
    List<BatchTrainer> findAll();
    public List<BatchTrainer> findAllByBatchId(Integer batchId);
    public List<BatchTrainer> findAllByTrainerId(Integer trainerId);  
   Page<BatchTrainer> findAll(Pageable pageable);
   @Query("SELECT bt FROM BatchTrainer bt WHERE bt.trainer.trainer.id = :personId")
    List<BatchTrainer> findByPersonId(Integer personId);

}