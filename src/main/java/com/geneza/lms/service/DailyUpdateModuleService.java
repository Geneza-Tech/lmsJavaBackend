package com.geneza.lms.service;
import com.geneza.lms.domain.DailyUpdateModule;
import java.util.List;

public interface DailyUpdateModuleService {
    public DailyUpdateModule findById(Integer id);
    public void saveDailyUpdateModule(DailyUpdateModule dailyUpdateModule_1);
    public boolean deleteDailyUpdateModule(Integer dailyUpdateModuleId);
    public List<DailyUpdateModule> findAll();
    public List<DailyUpdateModule> findAllByDailyUpdateId(Integer  dailyUpdate);
    public List<DailyUpdateModule> findAllByModuleId(Integer  module);
}