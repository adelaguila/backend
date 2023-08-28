package com.datasys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.datasys.model.User;
import com.datasys.repo.ILoginRepo;
import com.datasys.service.ILoginService;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements ILoginService{

    private final PasswordEncoder bcrypt;

    private final ILoginRepo repo;

    @Override
    public User checkUsername(String username) {
        return repo.checkUsername(username);
    }

    @Override
    public void changePassword(String password, String username) {
        repo.changePassword(bcrypt.encode(password), username);
    }
}
