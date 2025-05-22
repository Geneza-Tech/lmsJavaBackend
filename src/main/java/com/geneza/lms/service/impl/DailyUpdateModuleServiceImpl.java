package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.DailyUpdateModuleRepository;
import com.geneza.lms.domain.DailyUpdateModule;
import com.geneza.lms.service.DailyUpdateModuleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("DailyUpdateModuleService")
@Transactional
public class DailyUpdateModuleServiceImpl implements DailyUpdateModuleService {

    @Autowired
    private DailyUpdateModuleRepository dailyUpdateModuleRepository;
    public DailyUpdateModuleServiceImpl() {
    }

    @Transactional
    public DailyUpdateModule findById(Integer id) {
        return dailyUpdateModuleRepository.findById(id);
    }

    @Transactional
    public List<DailyUpdateModule> findAll() {
        return dailyUpdateModuleRepository.findAll();
    }
     
    @Transactional
    public void saveDailyUpdateModule(DailyUpdateModule dailyUpdateModule) {
        DailyUpdateModule existingDailyUpdateModule = dailyUpdateModuleRepository.findById(dailyUpdateModule.getId());
        if (existingDailyUpdateModule != null) {
        if (existingDailyUpdateModule != dailyUpdateModule) {      
        existingDailyUpdateModule.setId(dailyUpdateModule.getId());
                existingDailyUpdateModule.setDailyUpdate(dailyUpdateModule.getDailyUpdate());
                existingDailyUpdateModule.setModule(dailyUpdateModule.getModule());
        }
        dailyUpdateModule = dailyUpdateModuleRepository.save(existingDailyUpdateModule);
    }else{
        dailyUpdateModule = dailyUpdateModuleRepository.save(dailyUpdateModule);
        }
        dailyUpdateModuleRepository.flush();
    }

    public boolean deleteDailyUpdateModule(Integer dailyUpdateModuleId) {
        DailyUpdateModule dailyUpdateModule = dailyUpdateModuleRepository.findById(dailyUpdateModuleId);
        if(dailyUpdateModule!=null) {
            dailyUpdateModuleRepository.delete(dailyUpdateModule);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<DailyUpdateModule> findAllByDailyUpdateId(Integer  dailyUpdateId) {
        return new java.util.ArrayList<DailyUpdateModule>(dailyUpdateModuleRepository.findAllByDailyUpdateId(dailyUpdateId));
    }@Transactional
    public List<DailyUpdateModule> findAllByModuleId(Integer  moduleId) {
        return new java.util.ArrayList<DailyUpdateModule>(dailyUpdateModuleRepository.findAllByModuleId(moduleId));
    }

    

}