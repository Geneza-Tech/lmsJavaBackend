package com.geneza.lms.persistence;

import com.geneza.lms.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

    List<Session> findAllByBatchId(Integer batchId);

    List<Session> findAllByBatchModuleId(Integer batchModuleId);

    Page<Session> findAll(Pageable pageable);
}
