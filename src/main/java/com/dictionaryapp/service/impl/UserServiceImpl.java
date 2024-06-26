package com.dictionaryapp.service.impl;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.bindng.UserLoginDTO;
import com.dictionaryapp.model.dto.bindng.UserRegisterDTO;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final UserSession userSession;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder,
                           UserSession userSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    @Override
    public boolean register(UserRegisterDTO data) {

        if (!data.getPassword().equals(data.getConfirmPassword())) {
            return false;
        }

        boolean isUsernameOrEmailTaken = userRepository.existsByUsernameOrEmail(data.getUsername(), data.getEmail());

        if (isUsernameOrEmailTaken) {
            return false;
        }

        User mapped = modelMapper.map(data, User.class);
        mapped.setPassword(passwordEncoder.encode(mapped.getPassword()));

        userRepository.save(mapped);

        return true;
    }

    @Override
    public boolean login(UserLoginDTO data) {
        Optional<User> byUsername = userRepository.findByUsername(data.getUsername());

//        byUsername
//                .filter(...)
//                .map(user -> userSession.login(user))
//                .isPresent();

        if (byUsername.isEmpty()) {
            return false;
        }

        User user = byUsername.get();

        if (!passwordEncoder.matches(data.getPassword(), user.getPassword())){
            return false;
        }

        userSession.login(user);

        return true;
    }

    @Override
    public void logout() {
        userSession.logout();
    }
}
