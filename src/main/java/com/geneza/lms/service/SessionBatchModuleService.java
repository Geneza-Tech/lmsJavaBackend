package com.geneza.lms.service;

import java.util.List;

import com.geneza.lms.domain.SessionBatchModule;

public interface SessionBatchModuleService {

    SessionBatchModule save(SessionBatchModule entity);

    List<SessionBatchModule> saveAll(List<SessionBatchModule> entities);

    SessionBatchModule findById(Integer id);

    List<SessionBatchModule> findAll();

    List<SessionBatchModule> findAllBySessionId(Integer sessionId);

    List<SessionBatchModule> findAllByBatchModuleId(Integer batchModuleId);

    boolean deleteById(Integer id);

    SessionBatchModule create(SessionBatchModule entity);
    SessionBatchModule update(Integer id, SessionBatchModule entity);
}