package com.geneza.lms.persistence;  
import com.geneza.lms.domain.Trainer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {	 
    Trainer findById(Integer id);
    List<Trainer> findAll();
    public List<Trainer> findAllByTrainerId(Integer trainerId);  
   Page<Trainer> findAll(Pageable pageable);

}