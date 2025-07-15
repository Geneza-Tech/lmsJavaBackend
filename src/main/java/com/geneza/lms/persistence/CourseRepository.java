package com.geneza.lms.persistence;  
import com.geneza.lms.domain.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {	 
    Course findById(Integer id);
    List<Course> findAll();  
   Page<Course> findAll(Pageable pageable);

}