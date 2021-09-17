package com.library.ui.service;

import com.library.ui.constant.GenresListEnum;
import com.library.ui.domain.Book;
import com.library.ui.dto.BookSaveDto;

import java.util.List;

public interface BookService {
    Book save(BookSaveDto model);
    List<Book> findAll();
    List<Book> filterByGenre(Integer genre);
//    List<Book> filterByGenre(Enum<GenresListEnum> genre);
}
