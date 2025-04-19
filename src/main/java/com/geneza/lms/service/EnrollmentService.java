package com.geneza.lms.service;
import com.geneza.lms.domain.Batch;
import com.geneza.lms.domain.Enrollment;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnrollmentService {
    public Enrollment findById(Integer id);
    public void saveEnrollment(Enrollment enrollment_1);
    public boolean deleteEnrollment(Integer enrollmentId);
    public List<Enrollment> findAll();
    // public List<Enrollment> findAllByBatchId(Integer  batch);
    Page<Enrollment> findAllByBatchId(Integer batchId, Pageable pageable);
    public List<Enrollment> findAllByStudentId(Integer  student);
    List<Batch> findBatchesByStudentId(Integer studentId);
}