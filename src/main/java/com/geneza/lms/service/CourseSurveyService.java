package com.geneza.lms.service;
import com.geneza.lms.domain.CourseSurvey;
import java.util.List;

public interface CourseSurveyService {
    public CourseSurvey findById(Integer id);
    public void saveCourseSurvey(CourseSurvey courseSurvey_1);
    public boolean deleteCourseSurvey(Integer courseSurveyId);
    public List<CourseSurvey> findAll();
    public List<CourseSurvey> findAllByCourseId(Integer  course);
}