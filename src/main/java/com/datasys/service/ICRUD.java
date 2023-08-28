package com.datasys.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.datasys.commons.Filter;
import com.datasys.commons.SortModel;

public interface ICRUD<T, ID> {
    
    Page<?> pagination(Integer pagenumber, Integer rows, List<SortModel> sortModel, Filter filter );

    T save(T t);

    T update(T t, ID id);

    List<T> findAll();

    T findById(ID id);
    
    void delete(ID id);

}
