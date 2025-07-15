package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.CourseSurveyRepository;
import com.geneza.lms.domain.CourseSurvey;
import com.geneza.lms.service.CourseSurveyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CourseSurveyService")
@Transactional
public class CourseSurveyServiceImpl implements CourseSurveyService {

    @Autowired
    private CourseSurveyRepository courseSurveyRepository;
    public CourseSurveyServiceImpl() {
    }

    @Transactional
    public CourseSurvey findById(Integer id) {
        return courseSurveyRepository.findById(id);
    }

    @Transactional
    public List<CourseSurvey> findAll() {
        return courseSurveyRepository.findAll();
    }
     
    @Transactional
    public void saveCourseSurvey(CourseSurvey courseSurvey) {
        CourseSurvey existingCourseSurvey = courseSurveyRepository.findById(courseSurvey.getId());
        if (existingCourseSurvey != null) {
        if (existingCourseSurvey != courseSurvey) {      
        existingCourseSurvey.setId(courseSurvey.getId());
                existingCourseSurvey.setSurveyId(courseSurvey.getSurveyId());
                existingCourseSurvey.setCourse(courseSurvey.getCourse());
                existingCourseSurvey.setReceipientRole(courseSurvey.getReceipientRole());
                existingCourseSurvey.setLinkRole(courseSurvey.getLinkRole());
        }
        courseSurvey = courseSurveyRepository.save(existingCourseSurvey);
    }else{
        courseSurvey = courseSurveyRepository.save(courseSurvey);
        }
        courseSurveyRepository.flush();
    }

    public boolean deleteCourseSurvey(Integer courseSurveyId) {
        CourseSurvey courseSurvey = courseSurveyRepository.findById(courseSurveyId);
        if(courseSurvey!=null) {
            courseSurveyRepository.delete(courseSurvey);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<CourseSurvey> findAllByCourseId(Integer  courseId) {
        return new java.util.ArrayList<CourseSurvey>(courseSurveyRepository.findAllByCourseId(courseId));
    }

    

}