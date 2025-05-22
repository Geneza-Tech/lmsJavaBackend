package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.EnrollmentRepository;
import com.geneza.lms.domain.Batch;
import com.geneza.lms.domain.Enrollment;
import com.geneza.lms.service.EnrollmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("EnrollmentService")
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    public EnrollmentServiceImpl() {
    }

    @Transactional
    public Enrollment findById(Integer id) {
        return enrollmentRepository.findById(id);
    }

    @Transactional
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }
     
    @Transactional
    public void saveEnrollment(Enrollment enrollment) {
        Enrollment existingEnrollment = enrollmentRepository.findById(enrollment.getId());
        if (existingEnrollment != null) {
        if (existingEnrollment != enrollment) {      
        existingEnrollment.setId(enrollment.getId());
                existingEnrollment.setBatch(enrollment.getBatch());
                existingEnrollment.setStudent(enrollment.getStudent());
                existingEnrollment.setRole(enrollment.getRole());
        }
        enrollment = enrollmentRepository.save(existingEnrollment);
    }else{
        enrollment = enrollmentRepository.save(enrollment);
        }
        enrollmentRepository.flush();
    }

    public boolean deleteEnrollment(Integer enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId);
        if(enrollment!=null) {
            enrollmentRepository.delete(enrollment);
            return true;
        }else {
            return false;
        }
    }
    // @Transactional
    // public List<Enrollment> findAllByBatchId(Integer  batchId) {
    //     return new java.util.ArrayList<Enrollment>(enrollmentRepository.findAllByBatchId(batchId));
    // }

    @Transactional
    public Page<Enrollment> findAllByBatchId(Integer batchId, Pageable pageable) {
    return enrollmentRepository.findByBatchId(batchId, pageable);
    }

    
    
    
    @Transactional
    public List<Enrollment> findAllByStudentId(Integer  studentId) {
        return new java.util.ArrayList<Enrollment>(enrollmentRepository.findAllByStudentId(studentId));
    }

    @Override
    public List<Batch> findBatchesByStudentId(Integer studentId) {
        return enrollmentRepository.findBatchesByStudentId(studentId);
    }

    @Override
    public List<Enrollment> findAllByRole(String role) {
    return enrollmentRepository.findByRole( role);
    }

    @Override
    public List<Enrollment> findAllByBatchId(Integer batchId) {
        return enrollmentRepository.findByBatchId(batchId);
    }



}