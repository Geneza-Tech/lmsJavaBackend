package com.geneza.lms.service;
import com.geneza.lms.domain.DailyUpdate;
import java.util.List;

public interface DailyUpdateService {
    public DailyUpdate findById(Integer id);
    public void saveDailyUpdate(DailyUpdate dailyUpdate_1);
    public boolean deleteDailyUpdate(Integer dailyUpdateId);
    public List<DailyUpdate> findAll();
    public List<DailyUpdate> findAllByBatchId(Integer  batch);
}