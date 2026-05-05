package com.geneza.lms.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import com.geneza.lms.domain.enums.ReviewStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "submission_reviews")
public class SubmissionReview implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "assignmentSubmission")
    private AssignmentSubmission assignmentSubmission;

    @Column(name = "score")      private BigDecimal score;
    @Column(name = "created_at") private Date createdAt;
    @Column(name = "comments")   private String comments;
    @Enumerated(EnumType.STRING)
@Column(name = "status")
private ReviewStatus status;

    @ManyToOne
    @JoinColumn(name = "reviewedBy") // FK to BatchModuleTrainer
    private BatchModuleTrainer reviewedBy;
    // + getters/setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public AssignmentSubmission getAssignmentSubmission() { return assignmentSubmission; }
    public void setAssignmentSubmission(AssignmentSubmission assignmentSubmission) { this.assignmentSubmission = assignmentSubmission
    ; }

    public BigDecimal getScore() { return score; }
    public void setScore(BigDecimal score) { this.score = score; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public ReviewStatus getStatus() {
    return status;
}

public void setStatus(ReviewStatus status) {
    this.status = status;
}
    public BatchModuleTrainer getReviewedBy() { return reviewedBy; }
    public void setReviewedBy(BatchModuleTrainer reviewedBy) { this.reviewedBy =
            reviewedBy; }

    
}