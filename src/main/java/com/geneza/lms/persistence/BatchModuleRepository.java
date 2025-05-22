package com.geneza.lms.persistence;  
import com.geneza.lms.domain.BatchModule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface BatchModuleRepository extends JpaRepository<BatchModule, Long> {	 
    BatchModule findById(Integer id);
    List<BatchModule> findAll();
    public List<BatchModule> findAllByBatchId(Integer batchId);
    public List<BatchModule> findAllByModuleId(Integer moduleId);  
   Page<BatchModule> findAll(Pageable pageable);

}