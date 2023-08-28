package com.datasys.service;

import java.util.List;

import com.datasys.model.Menu;

public interface IMenuService extends ICRUD<Menu, Integer> {

    List<Menu> getMenusByUsername(String username);

}
