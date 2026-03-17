package com.geneza.lms.persistence;  
import com.geneza.lms.domain.CourseSurvey;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface CourseSurveyRepository extends JpaRepository<CourseSurvey, Long> {	 
    CourseSurvey findById(Integer id);
    List<CourseSurvey> findAll();
    public List<CourseSurvey> findAllByCourseId(Integer courseId);  
   Page<CourseSurvey> findAll(Pageable pageable);
   CourseSurvey findByCourseIdAndSurveyId(Integer courseId, Integer surveyId);


}