package com.geneza.lms.service.impl;

import com.geneza.lms.persistence.BatchModuleRepository;
import com.geneza.lms.persistence.BatchModuleTrainerRepository;
import com.geneza.lms.persistence.BatchTrainerRepository;
import com.geneza.lms.domain.BatchModule;
import com.geneza.lms.domain.BatchModuleTrainer;
import com.geneza.lms.domain.BatchTrainer;
import com.geneza.lms.dto.BatchModuleTrainerUpdateRequest;
import com.geneza.lms.dto.BatchTrainerUpdateRequest;
import com.geneza.lms.dto.ModuleTrainerRequest;
import com.geneza.lms.service.BatchModuleTrainerService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BatchModuleTrainerService")
@Transactional
public class BatchModuleTrainerServiceImpl implements BatchModuleTrainerService {

    @Autowired
    private BatchModuleTrainerRepository batchModuleTrainerRepository;

    @Autowired
private BatchTrainerRepository batchTrainerRepository;

       @Autowired
    private BatchModuleRepository batchModuleRepository;

    public BatchModuleTrainerServiceImpl() {
    }

    @Transactional
    public BatchModuleTrainer findById(Integer id) {
        return batchModuleTrainerRepository.findById(id);
    }

    @Transactional
    public List<BatchModuleTrainer> findAll() {
        return batchModuleTrainerRepository.findAll();
    }

    @Transactional
    public void saveBatchModuleTrainer(BatchModuleTrainer batchModuleTrainer) {
        BatchModuleTrainer existing = batchModuleTrainerRepository.findById(batchModuleTrainer.getId());
        if (existing != null) {
            if (existing != batchModuleTrainer) {
                existing.setId(batchModuleTrainer.getId());
                existing.setBatchModule(batchModuleTrainer.getBatchModule());
                existing.setBatchTrainer(batchModuleTrainer.getBatchTrainer());
            }
            batchModuleTrainer = batchModuleTrainerRepository.save(existing);
        } else {
            batchModuleTrainer = batchModuleTrainerRepository.save(batchModuleTrainer);
        }
        batchModuleTrainerRepository.flush();
    }

    public boolean deleteBatchModuleTrainer(Integer batchModuleTrainerId) {
        BatchModuleTrainer batchModuleTrainer = batchModuleTrainerRepository.findById(batchModuleTrainerId);
        if (batchModuleTrainer != null) {
            batchModuleTrainerRepository.delete(batchModuleTrainer);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public List<BatchModuleTrainer> findAllByBatchModuleId(Integer batchModuleId) {
        return new java.util.ArrayList<BatchModuleTrainer>(batchModuleTrainerRepository.findByBatchModuleId(batchModuleId));
    }

    @Transactional
    public List<BatchModuleTrainer> findAllByBatchTrainerId(Integer batchTrainerId) {
        return new java.util.ArrayList<BatchModuleTrainer>(batchModuleTrainerRepository.findByBatchTrainerId(batchTrainerId));
    }

    @Override
    public List<BatchModuleTrainer> findAllByBatchId(Integer batchId) {
        return batchModuleTrainerRepository.findByBatchModule_Batch_Id(batchId);
    }

    @Override
@Transactional
public void updateBatchModuleTrainers(BatchModuleTrainerUpdateRequest request) {

    Integer batchId = request.getBatchId();

    // 🔹 Load all BatchTrainers once (avoid N+1)
    List<BatchTrainer> batchTrainers =
            batchTrainerRepository.findAllByBatchId(batchId);

    // Map: trainerId → batchTrainerId
    Map<Integer, Integer> trainerToBatchTrainerMap = batchTrainers.stream()
            .collect(Collectors.toMap(
                    bt -> bt.getTrainer().getId(),
                    bt -> bt.getId()
            ));

    for (ModuleTrainerRequest moduleRequest : request.getModules()) {

        Integer moduleId = moduleRequest.getModuleId();
        List<Integer> trainerIds = moduleRequest.getTrainers();

        // 🔹 Find BatchModule
        BatchModule batchModule =
                batchModuleRepository.findByBatchIdAndModuleId(batchId, moduleId);

        if (batchModule == null) {
            continue; // or throw exception
        }

        Integer batchModuleId = batchModule.getId();

        // 🔹 Convert trainerIds → batchTrainerIds
        List<Integer> batchTrainerIds = trainerIds.stream()
                .map(trainerToBatchTrainerMap::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        // 🔹 Call optimized insert
        addBatchModuleTrainers(batchModuleId, batchTrainerIds);
    }
}

    @Transactional
public void addBatchModuleTrainers(Integer batchModuleId, List<Integer> batchTrainerIds) {

    // 🔹 Existing mappings
    List<BatchModuleTrainer> existing =
            batchModuleTrainerRepository.findByBatchModuleId(batchModuleId);

    Set<Integer> existingIds = existing.stream()
            .map(b -> b.getBatchTrainer().getId())
            .collect(Collectors.toSet());

    List<BatchModuleTrainer> toAdd = new ArrayList<>();

    for (Integer batchTrainerId : batchTrainerIds) {

        if (!existingIds.contains(batchTrainerId)) {

            BatchModuleTrainer bmt = new BatchModuleTrainer();

            BatchModule bmRef = new BatchModule();
            bmRef.setId(batchModuleId);

            BatchTrainer btRef = new BatchTrainer();
            btRef.setId(batchTrainerId);

            bmt.setBatchModule(bmRef);
            bmt.setBatchTrainer(btRef);

            toAdd.add(bmt);
        }
    }

    if (!toAdd.isEmpty()) {
        batchModuleTrainerRepository.saveAll(toAdd);
        batchModuleTrainerRepository.flush();
    }
}
   


}