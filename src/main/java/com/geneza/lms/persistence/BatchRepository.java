package com.geneza.lms.persistence;  
import com.geneza.lms.domain.Batch;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long>, JpaSpecificationExecutor<Batch>  {	 
    Batch findById(Integer id);
    List<Batch> findAll();
    public List<Batch> findAllByCourseId(Integer courseId);
    public List<Batch> findAllByCountryId(Integer countryId);
    public List<Batch> findAllByBatchStatusId(Integer batchStatusId);
    List<Batch> findAllByCourseIdAndCountryIdAndBatchStatusId(Integer courseId, Integer countryId, Integer batchStatusId);
    // Page<Batch> findAllByCcbsPage(Integer courseId, Integer countryId, Integer batchStatusId,Pageable pageable);  
   Page<Batch> findAll(Pageable pageable);

}