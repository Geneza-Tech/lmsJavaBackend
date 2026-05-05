package com.geneza.lms.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geneza.lms.domain.SessionBatchModule;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@Repository
public interface SessionBatchModuleRepository extends JpaRepository<SessionBatchModule, Integer> {

    List<SessionBatchModule> findAllBySessionId(Integer sessionId);

    List<SessionBatchModule> findAllByBatchModuleId(Integer batchModuleId);
}
