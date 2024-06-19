package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.bindng.UserLoginDTO;
import com.dictionaryapp.model.dto.bindng.UserRegisterDTO;

public interface UserService {

    public boolean register(UserRegisterDTO data);

    public boolean login(UserLoginDTO data);

    void logout();
}
