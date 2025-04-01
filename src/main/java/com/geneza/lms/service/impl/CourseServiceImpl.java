package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.CourseRepository;
import com.geneza.lms.domain.Course;
import com.geneza.lms.service.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CourseService")
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    public CourseServiceImpl() {
    }

    @Transactional
    public Course findById(Integer id) {
        return courseRepository.findById(id);
    }

    @Transactional
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
     
    @Transactional
    public void saveCourse(Course course) {
        Course existingCourse = courseRepository.findById(course.getId());
        if (existingCourse != null) {
        if (existingCourse != course) {      
        existingCourse.setId(course.getId());
                existingCourse.setCourse(course.getCourse());
                existingCourse.setDescription(course.getDescription());
        }
        course = courseRepository.save(existingCourse);
    }else{
        course = courseRepository.save(course);
        }
        courseRepository.flush();
    }

    public boolean deleteCourse(Integer courseId) {
        Course course = courseRepository.findById(courseId);
        if(course!=null) {
            courseRepository.delete(course);
            return true;
        }else {
            return false;
        }
    }

    

}