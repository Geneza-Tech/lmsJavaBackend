package com.geneza.lms.persistence;  
import com.geneza.lms.domain.Assignment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {	 
    Assignment findById(Integer id);
    List<Assignment> findAll();
    public List<Assignment> findAllByModuleId(Integer moduleId);  
   Page<Assignment> findAll(Pageable pageable);

}