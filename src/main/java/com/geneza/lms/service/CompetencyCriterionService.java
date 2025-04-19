package com.geneza.lms.service;
import com.geneza.lms.domain.CompetencyCriterion;
import java.util.List;

public interface CompetencyCriterionService {
    public CompetencyCriterion findById(Integer id);
    public void saveCompetencyCriterion(CompetencyCriterion competencyCriterion_1);
    public boolean deleteCompetencyCriterion(Integer competencyCriterionId);
    public List<CompetencyCriterion> findAll();
    public List<CompetencyCriterion> findAllByCompetencyCategoryId(Integer  competencyCategory);
}