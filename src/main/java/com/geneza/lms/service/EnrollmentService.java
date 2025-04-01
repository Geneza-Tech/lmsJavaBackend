package com.geneza.lms.service;
import com.geneza.lms.domain.Enrollment;
import java.util.List;

public interface EnrollmentService {
    public Enrollment findById(Integer id);
    public void saveEnrollment(Enrollment enrollment_1);
    public boolean deleteEnrollment(Integer enrollmentId);
    public List<Enrollment> findAll();
    public List<Enrollment> findAllByBatchId(Integer  batch);
    public List<Enrollment> findAllByStudentId(Integer  student);
}