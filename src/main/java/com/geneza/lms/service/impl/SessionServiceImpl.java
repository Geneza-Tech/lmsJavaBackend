package com.geneza.lms.service.impl;

import com.geneza.lms.service.SessionService;

import com.geneza.lms.domain.Session;
import com.geneza.lms.persistence.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;


import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public Session save(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session findById(Integer id) {
        return sessionRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Session not found with ID: " + id));
    }

    @Override
    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Page<Session> findAll(Pageable pageable) {
        return sessionRepository.findAll(pageable);
    }

    @Override
    public List<Session> findAllByBatchId(Integer batchId) {
        return sessionRepository.findAllByBatchId(batchId);
    }

    @Override
    public List<Session> findAllByBatchModuleId(Integer batchModuleId) {
        return sessionRepository.findAllByBatchModuleId(batchModuleId);
    }

    @Override
public boolean deleteById(Integer id) {
    if (sessionRepository.existsById(id)) {
        sessionRepository.deleteById(id);
        return true;
    } else {
        return false;
    }
}


}
