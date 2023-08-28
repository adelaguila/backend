package com.datasys.service;

import com.datasys.model.ResetMail;

public interface IResetMailService {

    ResetMail findByRandom(String random);

    void save(ResetMail random);

    void delete(ResetMail random);

}
