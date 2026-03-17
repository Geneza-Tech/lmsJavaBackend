package com.geneza.lms.dto;

import com.geneza.lms.domain.Batch;
import com.geneza.lms.domain.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BatchDTO {

    private Integer id;
    private String batch;
    private Date startDate;
    private Date endDate;
    private String location;

    private String courseName;
    private String countryName;
    private String batchStatusName;
    private List<TrainerDTO> trainers;

    public BatchDTO(Batch batch) {

    this.id = batch.getId();
    this.batch = batch.getBatch();
    this.startDate = batch.getStartDate();
    this.endDate = batch.getEndDate();
    this.location = batch.getLocation();

    this.courseName = batch.getCourse() != null ? batch.getCourse().getName() : null;
    this.countryName = batch.getCountry() != null ? batch.getCountry().getCountry() : null;
    this.batchStatusName = batch.getBatchStatus() != null ? batch.getBatchStatus().getName() : null;

    // ✅ ADD THIS BLOCK
    this.trainers = new ArrayList<>();

    if (batch.getBatchTrainers() != null) {
        batch.getBatchTrainers().forEach(bt -> {

            if (bt.getTrainer() != null && bt.getTrainer().getTrainer() != null) {

                Person person = bt.getTrainer().getTrainer();

                TrainerDTO trainerDTO = new TrainerDTO(
                        person.getId(),
                        person.getFirstName() + " " + person.getLastName(),
                        person.getEmail()
                );

                this.trainers.add(trainerDTO);
            }
        });
    }
}

    // Getters and setters here (or use Lombok @Data)

    public Integer getId() {
        return id;
    }

    public String getBatchName() {
        return batch;
    }
    

    public String getCourseName() {
        return courseName;
    }

    public String getBatchStatusName() {
        return batchStatusName;
    }

    

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public List<TrainerDTO> getTrainers() {
    return trainers;
}

    
}
