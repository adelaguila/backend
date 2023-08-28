package com.datasys.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.datasys.commons.Filter;
import com.datasys.commons.SortModel;
import com.datasys.model.Via;
import com.datasys.repo.IGenericRepo;
import com.datasys.repo.IViaRepo;
import com.datasys.service.IViaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViaServiceImpl extends CRUDImpl<Via, Integer> implements IViaService {

    private final IViaRepo repo;

    @Override
    protected IGenericRepo<Via, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<?> pagination(Integer pagenumber, Integer rows, List<SortModel> sortModel, Filter filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagination'");
    }

}
