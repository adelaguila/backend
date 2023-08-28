package com.datasys.service;

import java.time.LocalDateTime;
import java.util.List;

import com.datasys.dto.ConsultProcDTO;
import com.datasys.dto.IConsultProcDTO;
import com.datasys.model.Consult;
import com.datasys.model.Exam;

public interface IConsultService extends ICRUD<Consult, Integer> {

    Consult saveTransactional(Consult consult, List<Exam> exams);
    List<Consult> search(String dni, String fullname);
    List<Consult> searchByDates(LocalDateTime date1, LocalDateTime date2);
    List<ConsultProcDTO> callProcedureOrFunctionNative();
    List<IConsultProcDTO> callProcedureOrFunctionProjection();
    byte[] generateReport() throws Exception;
}
