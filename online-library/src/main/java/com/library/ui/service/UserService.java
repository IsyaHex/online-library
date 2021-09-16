package com.library.ui.service;

import com.library.ui.domain.User;
import com.library.ui.dto.UserSaveDto;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface UserService {
    User save(UserSaveDto model);
    List<User> findAll();
}
