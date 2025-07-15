package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.CompetencyCategoryRepository;
import com.geneza.lms.domain.CompetencyCategory;
import com.geneza.lms.service.CompetencyCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CompetencyCategoryService")
@Transactional
public class CompetencyCategoryServiceImpl implements CompetencyCategoryService {

    @Autowired
    private CompetencyCategoryRepository competencyCategoryRepository;
    public CompetencyCategoryServiceImpl() {
    }

    @Transactional
    public CompetencyCategory findById(Integer id) {
        return competencyCategoryRepository.findById(id);
    }

    @Transactional
    public List<CompetencyCategory> findAll() {
        return competencyCategoryRepository.findAll();
    }
     
    @Transactional
    public void saveCompetencyCategory(CompetencyCategory competencyCategory) {
        CompetencyCategory existingCompetencyCategory = competencyCategoryRepository.findById(competencyCategory.getId());
        if (existingCompetencyCategory != null) {
        if (existingCompetencyCategory != competencyCategory) {      
        existingCompetencyCategory.setId(competencyCategory.getId());
                existingCompetencyCategory.setCompetencyCategory(competencyCategory.getCompetencyCategory());
        }
        competencyCategory = competencyCategoryRepository.save(existingCompetencyCategory);
    }else{
        competencyCategory = competencyCategoryRepository.save(competencyCategory);
        }
        competencyCategoryRepository.flush();
    }

    public boolean deleteCompetencyCategory(Integer competencyCategoryId) {
        CompetencyCategory competencyCategory = competencyCategoryRepository.findById(competencyCategoryId);
        if(competencyCategory!=null) {
            competencyCategoryRepository.delete(competencyCategory);
            return true;
        }else {
            return false;
        }
    }

    

}