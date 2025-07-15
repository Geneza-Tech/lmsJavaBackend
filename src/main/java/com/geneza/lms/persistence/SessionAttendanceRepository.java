package com.geneza.lms.persistence;

import com.geneza.lms.domain.SessionAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface SessionAttendanceRepository extends JpaRepository<SessionAttendance, Integer> {

    List<SessionAttendance> findAllBySessionId(Integer sessionId);

    List<SessionAttendance> findAllByEnrollmentId(Integer enrollmentId);

    List<SessionAttendance> findAllBySessionIdAndEnrollmentId(Integer sessionId, Integer enrollmentId);

    Page<SessionAttendance> findAll(Pageable pageable);

    List<SessionAttendance> findBySession_Batch_Id(Integer batchId);

}
