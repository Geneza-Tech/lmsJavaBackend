package com.geneza.lms.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geneza.lms.domain.SessionBatchModule;
import com.geneza.lms.persistence.SessionBatchModuleRepository;
import com.geneza.lms.service.SessionBatchModuleService;

@Service
public class SessionBatchModuleServiceImpl implements SessionBatchModuleService {

    @Autowired
    private SessionBatchModuleRepository repository;

    @Override
    public SessionBatchModule save(SessionBatchModule entity) {
        return repository.save(entity);
    }

    @Override
    public List<SessionBatchModule> saveAll(List<SessionBatchModule> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public SessionBatchModule findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found: " + id));
    }

    @Override
    public List<SessionBatchModule> findAll() {
        return repository.findAll();
    }

    @Override
    public List<SessionBatchModule> findAllBySessionId(Integer sessionId) {
        return repository.findAllBySessionId(sessionId);
    }

    @Override
    public List<SessionBatchModule> findAllByBatchModuleId(Integer batchModuleId) {
        return repository.findAllByBatchModuleId(batchModuleId);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
public SessionBatchModule create(SessionBatchModule entity) {
    if (entity.getId() != null) {
        throw new IllegalArgumentException("New entity cannot have ID");
    }
    return repository.save(entity);
}

@Override
public SessionBatchModule update(Integer id, SessionBatchModule entity) {

    SessionBatchModule existing = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Not found"));

    existing.setSession(entity.getSession());
    existing.setBatchModule(entity.getBatchModule());

    return repository.save(existing);
}
}
