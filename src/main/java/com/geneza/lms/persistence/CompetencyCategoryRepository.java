package com.geneza.lms.persistence;  
import com.geneza.lms.domain.CompetencyCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface CompetencyCategoryRepository extends JpaRepository<CompetencyCategory, Long> {	 
    CompetencyCategory findById(Integer id);
    List<CompetencyCategory> findAll();  
   Page<CompetencyCategory> findAll(Pageable pageable);

}