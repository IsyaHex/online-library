package com.library.ui.service;

import com.library.ui.domain.Book;
import com.library.ui.dto.BookSaveDto;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface BookService {
    Book save(BookSaveDto model);
    List<Book> findAll();
}
