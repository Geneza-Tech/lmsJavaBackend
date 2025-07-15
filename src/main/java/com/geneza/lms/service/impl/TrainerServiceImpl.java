package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.TrainerRepository;
import com.geneza.lms.domain.Trainer;
import com.geneza.lms.service.TrainerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TrainerService")
@Transactional
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;
    public TrainerServiceImpl() {
    }

    @Transactional
    public Trainer findById(Integer id) {
        return trainerRepository.findById(id);
    }

    @Transactional
    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }
     
    @Transactional
    public void saveTrainer(Trainer trainer) {
        Trainer existingTrainer = trainerRepository.findById(trainer.getId());
        if (existingTrainer != null) {
        if (existingTrainer != trainer) {      
        existingTrainer.setId(trainer.getId());
                existingTrainer.setTrainer(trainer.getTrainer());
        }
        trainer = trainerRepository.save(existingTrainer);
    }else{
        trainer = trainerRepository.save(trainer);
        }
        trainerRepository.flush();
    }

    public boolean deleteTrainer(Integer trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId);
        if(trainer!=null) {
            trainerRepository.delete(trainer);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<Trainer> findAllByTrainerId(Integer  trainerId) {
        return new java.util.ArrayList<Trainer>(trainerRepository.findAllByTrainerId(trainerId));
    }

    

}