package com.geneza.lms.persistence;  
import com.geneza.lms.domain.BatchMentor;
import com.geneza.lms.domain.Mentor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {	 
    Mentor findById(Integer id);
    List<Mentor> findAll();
    public List<Mentor> findAllByMentorId(Integer mentorId);  
   Page<Mentor> findAll(Pageable pageable);
   


}