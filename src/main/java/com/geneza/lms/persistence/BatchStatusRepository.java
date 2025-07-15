package com.geneza.lms.persistence;  
import com.geneza.lms.domain.BatchStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface BatchStatusRepository extends JpaRepository<BatchStatus, Long> {	 
    BatchStatus findById(Integer id);
    List<BatchStatus> findAll();  
   Page<BatchStatus> findAll(Pageable pageable);

}