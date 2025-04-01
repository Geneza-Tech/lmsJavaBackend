package com.geneza.lms.persistence;  
import com.geneza.lms.domain.Module;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {	 
    Module findById(Integer id);
    List<Module> findAll();
    public List<Module> findAllByCourseId(Integer courseId);  
   Page<Module> findAll(Pageable pageable);

}