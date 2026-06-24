package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.BatchModuleRepository;
import com.geneza.lms.domain.Batch;
import com.geneza.lms.domain.BatchModule;
import com.geneza.lms.domain.Module;
import com.geneza.lms.dto.BatchModuleUpdateRequest;
import com.geneza.lms.service.BatchModuleService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BatchModuleService")
@Transactional
public class BatchModuleServiceImpl implements BatchModuleService {

    @Autowired
    private BatchModuleRepository batchModuleRepository;
    public BatchModuleServiceImpl() {
    }

    @Transactional
    public BatchModule findById(Integer id) {
        return batchModuleRepository.findById(id);
    }

    @Transactional
    public List<BatchModule> findAll() {
        return batchModuleRepository.findAll();
    }
     
    @Transactional
    public void saveBatchModule(BatchModule batchModule) {
        BatchModule existingBatchModule = batchModuleRepository.findById(batchModule.getId());
        if (existingBatchModule != null) {
        if (existingBatchModule != batchModule) {      
        existingBatchModule.setId(batchModule.getId());
                existingBatchModule.setBatch(batchModule.getBatch());
                existingBatchModule.setModule(batchModule.getModule());
                existingBatchModule.setStatus(batchModule.getStatus());
        }
        batchModule = batchModuleRepository.save(existingBatchModule);
    }else{
        batchModule = batchModuleRepository.save(batchModule);
        }
        batchModuleRepository.flush();
    }

    public boolean deleteBatchModule(Integer batchModuleId) {
        BatchModule batchModule = batchModuleRepository.findById(batchModuleId);
        if(batchModule!=null) {
            batchModuleRepository.delete(batchModule);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<BatchModule> findAllByBatchId(Integer  batchId) {
        return new java.util.ArrayList<BatchModule>(batchModuleRepository.findAllByBatchId(batchId));
    }@Transactional
    public List<BatchModule> findAllByModuleId(Integer  moduleId) {
        return new java.util.ArrayList<BatchModule>(batchModuleRepository.findAllByModuleId(moduleId));
    }

    @Override
@Transactional
public void updateBatchModules(BatchModuleUpdateRequest request) {

    Integer batchId = request.getBatchId();
    List<Integer> moduleIds = request.getModuleIds();

    List<BatchModule> existing =
            batchModuleRepository.findAllByBatchId(batchId);

    Set<Integer> existingModuleIds = existing.stream()
            .map(bm -> bm.getModule().getId())
            .collect(Collectors.toSet());

    Set<Integer> newModuleIds = new HashSet<>(moduleIds);

    // =========================
    // ➕ ADD ONLY (SAFE)
    // =========================
    List<BatchModule> toAdd = new ArrayList<>();

    for (Integer moduleId : newModuleIds) {

        if (!existingModuleIds.contains(moduleId)) {

            BatchModule bm = new BatchModule();

            Batch batch = new Batch();
            batch.setId(batchId);

            Module module = new Module();
            module.setId(moduleId);

            bm.setBatch(batch);
            bm.setModule(module);

            toAdd.add(bm);
        }
    }

    batchModuleRepository.saveAll(toAdd);
    batchModuleRepository.flush();
}
}