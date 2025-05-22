package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.DailyUpdateRepository;
import com.geneza.lms.domain.DailyUpdate;
import com.geneza.lms.service.DailyUpdateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("DailyUpdateService")
@Transactional
public class DailyUpdateServiceImpl implements DailyUpdateService {

    @Autowired
    private DailyUpdateRepository dailyUpdateRepository;
    public DailyUpdateServiceImpl() {
    }

    @Transactional
    public DailyUpdate findById(Integer id) {
        return dailyUpdateRepository.findById(id);
    }

    @Transactional
    public List<DailyUpdate> findAll() {
        return dailyUpdateRepository.findAll();
    }
     
    @Transactional
    public void saveDailyUpdate(DailyUpdate dailyUpdate) {
        DailyUpdate existingDailyUpdate = dailyUpdateRepository.findById(dailyUpdate.getId());
        if (existingDailyUpdate != null) {
        if (existingDailyUpdate != dailyUpdate) {      
        existingDailyUpdate.setId(dailyUpdate.getId());
                existingDailyUpdate.setBatch(dailyUpdate.getBatch());
                existingDailyUpdate.setDate(dailyUpdate.getDate());
                existingDailyUpdate.setField1(dailyUpdate.getField1());
                existingDailyUpdate.setField2(dailyUpdate.getField2());
                existingDailyUpdate.setField3(dailyUpdate.getField3());
        }
        dailyUpdate = dailyUpdateRepository.save(existingDailyUpdate);
    }else{
        dailyUpdate = dailyUpdateRepository.save(dailyUpdate);
        }
        dailyUpdateRepository.flush();
    }

    public boolean deleteDailyUpdate(Integer dailyUpdateId) {
        DailyUpdate dailyUpdate = dailyUpdateRepository.findById(dailyUpdateId);
        if(dailyUpdate!=null) {
            dailyUpdateRepository.delete(dailyUpdate);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<DailyUpdate> findAllByBatchId(Integer  batchId) {
        return new java.util.ArrayList<DailyUpdate>(dailyUpdateRepository.findAllByBatchId(batchId));
    }

    

}