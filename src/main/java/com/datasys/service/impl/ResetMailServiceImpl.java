package com.datasys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.datasys.model.ResetMail;
import com.datasys.repo.IResetMailRepo;
import com.datasys.service.IResetMailService;

@Service
@RequiredArgsConstructor
public class ResetMailServiceImpl implements IResetMailService {

    private final IResetMailRepo repo;

    @Override
    public ResetMail findByRandom(String random) {
        return repo.findByRandom(random);
    }

    @Override
    public void save(ResetMail random) {
        repo.save(random);
    }

    @Override
    public void delete(ResetMail random) {
        repo.delete(random);
    }
}
