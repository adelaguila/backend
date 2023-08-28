package com.datasys.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasys.model.Medic;
import com.datasys.model.Patient;

public interface IMedicRepo extends IGenericRepo<Medic, Integer> {

}
