package com.geneza.lms.service;
import com.geneza.lms.domain.Trainer;
import java.util.List;

public interface TrainerService {
    public Trainer findById(Integer id);
    public void saveTrainer(Trainer trainer_1);
    public boolean deleteTrainer(Integer trainerId);
    public List<Trainer> findAll();
    public List<Trainer> findAllByTrainerId(Integer  trainer);
}