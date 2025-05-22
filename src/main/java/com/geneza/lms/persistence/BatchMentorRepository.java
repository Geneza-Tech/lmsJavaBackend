package com.geneza.lms.persistence;  
import com.geneza.lms.domain.BatchMentor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface BatchMentorRepository extends JpaRepository<BatchMentor, Long> {	 
    BatchMentor findById(Integer id);
    List<BatchMentor> findAll();
    public List<BatchMentor> findAllByBatchId(Integer batchId);
    public List<BatchMentor> findAllByMentorId(Integer mentorId);  
   Page<BatchMentor> findAll(Pageable pageable);
    @Query("SELECT bm FROM BatchMentor bm WHERE bm.mentor.mentor.id = :personId")
    List<BatchMentor> findByPersonId(Integer personId);
}