package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.CompetencyCriterionRepository;
import com.geneza.lms.domain.CompetencyCriterion;
import com.geneza.lms.service.CompetencyCriterionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CompetencyCriterionService")
@Transactional
public class CompetencyCriterionServiceImpl implements CompetencyCriterionService {

    @Autowired
    private CompetencyCriterionRepository competencyCriterionRepository;
    public CompetencyCriterionServiceImpl() {
    }

    @Transactional
    public CompetencyCriterion findById(Integer id) {
        return competencyCriterionRepository.findById(id);
    }

    @Transactional
    public List<CompetencyCriterion> findAll() {
        return competencyCriterionRepository.findAll();
    }
     
    @Transactional
    public void saveCompetencyCriterion(CompetencyCriterion competencyCriterion) {
        CompetencyCriterion existingCompetencyCriterion = competencyCriterionRepository.findById(competencyCriterion.getId());
        if (existingCompetencyCriterion != null) {
        if (existingCompetencyCriterion != competencyCriterion) {      
        existingCompetencyCriterion.setId(competencyCriterion.getId());
                existingCompetencyCriterion.setComptenecyCriterion(competencyCriterion.getComptenecyCriterion());
                existingCompetencyCriterion.setCompetencyCategory(competencyCriterion.getCompetencyCategory());
        }
        competencyCriterion = competencyCriterionRepository.save(existingCompetencyCriterion);
    }else{
        competencyCriterion = competencyCriterionRepository.save(competencyCriterion);
        }
        competencyCriterionRepository.flush();
    }

    public boolean deleteCompetencyCriterion(Integer competencyCriterionId) {
        CompetencyCriterion competencyCriterion = competencyCriterionRepository.findById(competencyCriterionId);
        if(competencyCriterion!=null) {
            competencyCriterionRepository.delete(competencyCriterion);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<CompetencyCriterion> findAllByCompetencyCategoryId(Integer  competencyCategoryId) {
        return new java.util.ArrayList<CompetencyCriterion>(competencyCriterionRepository.findAllByCompetencyCategoryId(competencyCategoryId));
    }

    

}