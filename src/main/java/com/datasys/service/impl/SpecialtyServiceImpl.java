package com.datasys.service.impl;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.datasys.commons.Filter;
import com.datasys.commons.SortModel;
import com.datasys.model.Specialty;
import com.datasys.repo.IGenericRepo;
import com.datasys.repo.ISpecialtyRepo;
import com.datasys.service.ISpecialtyService;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl extends CRUDImpl<Specialty, Integer> implements ISpecialtyService {

    private final ISpecialtyRepo repo;

    @Override
    protected IGenericRepo<Specialty, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<?> pagination(Integer pagenumber, Integer rows, List<SortModel> sortModel, Filter filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagination'");
    }

}
