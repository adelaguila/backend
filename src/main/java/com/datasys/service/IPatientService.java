package com.datasys.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.datasys.model.Patient;

import java.util.List;

public interface IPatientService extends ICRUD<Patient, Integer>{

    Page<Patient> listPage(Pageable pageable);
    List<Patient> getPatients1(String name);
}
