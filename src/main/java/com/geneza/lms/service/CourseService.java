package com.geneza.lms.service;
import com.geneza.lms.domain.Course;
import java.util.List;

public interface CourseService {
    public Course findById(Integer id);
    public void saveCourse(Course course_1);
    public boolean deleteCourse(Integer courseId);
    public List<Course> findAll();
}