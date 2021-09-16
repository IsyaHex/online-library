package com.library.ui.service;

import com.library.ui.domain.Author;
import com.library.ui.dto.AuthorSaveDto;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface AuthorService{
    Author save(AuthorSaveDto model);
    List<Author> findAll();
}
