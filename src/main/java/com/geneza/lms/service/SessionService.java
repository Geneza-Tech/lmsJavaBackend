package com.geneza.lms.service;

import com.geneza.lms.domain.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SessionService {
    Session save(Session session);
    Session findById(Integer id);
    List<Session> findAll();
    Page<Session> findAll(Pageable pageable);
    List<Session> findAllByBatchId(Integer batchId);
    List<Session> findAllByBatchModuleId(Integer batchModuleId);
    boolean deleteById(Integer id);

}
