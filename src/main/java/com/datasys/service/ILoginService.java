package com.datasys.service;

import com.datasys.model.User;

public interface ILoginService {

    User checkUsername(String username);
    void changePassword(String password, String username);
}
