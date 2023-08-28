package com.datasys.service;

import java.util.List;

import com.datasys.model.ConsultExam;

public interface IConsultExamService {

    List<ConsultExam> getExamsByConsultId(Integer idConsult);

}
