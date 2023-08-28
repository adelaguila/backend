package com.datasys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.datasys.commons.Filter;
import com.datasys.commons.SortModel;
import com.datasys.model.Patient;
import com.datasys.repo.IGenericRepo;
import com.datasys.repo.IPatientRepo;
import com.datasys.repo.PatientRepoImpl;
import com.datasys.service.IPatientService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl extends CRUDImpl<Patient, Integer> implements IPatientService {

    //@Autowired
    private final IPatientRepo repo;// = new PatientRepo();
    private final PatientRepoImpl repoImpl;

    @Override
    protected IGenericRepo<Patient, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Patient> listPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<Patient> getPatients1(String name) {
        return repoImpl.getPatients1(name);
    }

    @Override
    public Page<?> pagination(Integer pagenumber, Integer rows, List<SortModel> sortModel, Filter filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagination'");
    }
}
