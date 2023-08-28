package com.datasys.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.datasys.commons.Filter;
import com.datasys.commons.SortModel;
import com.datasys.model.Sector;
import com.datasys.repo.IGenericRepo;
import com.datasys.repo.ISectorRepo;
import com.datasys.service.ISectorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SectorServiceImpl extends CRUDImpl<Sector, Integer> implements ISectorService {

    private final ISectorRepo repo;

    @Override
    protected IGenericRepo<Sector, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<?> pagination(Integer pagenumber, Integer rows, List<SortModel> sortModel, Filter filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagination'");
    }

}
