package com.library.ui.service.impl;

import com.library.ui.constant.UserStateEnum;
import com.library.ui.domain.User;
import com.library.ui.dto.UserSaveDto;
import com.library.ui.repository.UserRepository;
import com.library.ui.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserSaveDto model) {
//        User user = userRepository.findById(model.getRole().getId())
//                .orElseThrow(() -> new IllegalArgumentException("Выбрана несуществующая роль"));
        User user = new User();
        addNewUser(model, user);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    private void addNewUser(UserSaveDto model, User user) {
        user.setUsername(model.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(model.getPassword()));
        user.setName(model.getName());
        user.setCreateDate(ZonedDateTime.now());
        user.setState(UserStateEnum.ACTIVE.getState());
        user.setRole(model.getRole());
    }
}
