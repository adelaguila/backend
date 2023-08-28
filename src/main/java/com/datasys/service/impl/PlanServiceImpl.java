package com.datasys.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.datasys.commons.Filter;
import com.datasys.commons.SortModel;
import com.datasys.model.Plan;
import com.datasys.repo.IGenericRepo;
import com.datasys.repo.IPlanRepo;
import com.datasys.service.IPlanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl extends CRUDImpl<Plan, Integer> implements IPlanService {

    private final IPlanRepo repo;

    @Override
    protected IGenericRepo<Plan, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<?> pagination(Integer pagenumber, Integer rows, List<SortModel> sortModel, Filter filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagination'");
    }

}
