package com.geneza.lms.persistence;  
import com.geneza.lms.domain.DailyUpdateModule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface DailyUpdateModuleRepository extends JpaRepository<DailyUpdateModule, Long> {	 
    DailyUpdateModule findById(Integer id);
    List<DailyUpdateModule> findAll();
    public List<DailyUpdateModule> findAllByDailyUpdateId(Integer dailyUpdateId);
    public List<DailyUpdateModule> findAllByModuleId(Integer moduleId);  
   Page<DailyUpdateModule> findAll(Pageable pageable);

}