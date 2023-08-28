package com.datasys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.datasys.model.ConsultExam;
import com.datasys.repo.IConsultExamRepo;
import com.datasys.service.IConsultExamService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultExamServiceImpl implements IConsultExamService {

    private final IConsultExamRepo repo;

    @Override
    public List<ConsultExam> getExamsByConsultId(Integer idConsult) {
        return repo.getExamsByConsultId(idConsult);
    }
}
