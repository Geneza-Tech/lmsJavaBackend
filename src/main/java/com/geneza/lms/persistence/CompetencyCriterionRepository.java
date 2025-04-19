package com.geneza.lms.persistence;  
import com.geneza.lms.domain.CompetencyCriterion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface CompetencyCriterionRepository extends JpaRepository<CompetencyCriterion, Long> {	 
    CompetencyCriterion findById(Integer id);
    List<CompetencyCriterion> findAll();
    public List<CompetencyCriterion> findAllByCompetencyCategoryId(Integer competencyCategoryId);  
   Page<CompetencyCriterion> findAll(Pageable pageable);

}