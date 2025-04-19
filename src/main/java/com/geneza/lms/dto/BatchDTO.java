package com.geneza.lms.dto;

import com.geneza.lms.domain.Batch;

import java.util.Date;

public class BatchDTO {

    private Integer id;
    private String batch;
    private Date startDate;
    private Date endDate;
    private String location;

    private String courseName;
    private String countryName;
    private String batchStatusName;

    public BatchDTO(Batch batch) {
        this.id = batch.getId();
        this.batch = batch.getBatch();
        this.startDate = batch.getStartDate();
        this.endDate = batch.getEndDate();
        this.location = batch.getLocation();
        this.courseName = batch.getCourse() != null ? batch.getCourse().getName() : null;
        this.countryName = batch.getCountry() != null ? batch.getCountry().getCountry() : null;
        this.batchStatusName = batch.getBatchStatus() != null ? batch.getBatchStatus().getName() : null;
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

    
}
