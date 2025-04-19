package com.geneza.lms.service;
import com.geneza.lms.domain.CompetencyCategory;
import java.util.List;

public interface CompetencyCategoryService {
    public CompetencyCategory findById(Integer id);
    public void saveCompetencyCategory(CompetencyCategory competencyCategory_1);
    public boolean deleteCompetencyCategory(Integer competencyCategoryId);
    public List<CompetencyCategory> findAll();
}