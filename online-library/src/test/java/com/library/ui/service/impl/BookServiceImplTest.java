package com.library.ui.service.impl;

import com.library.ui.domain.Book;
import com.library.ui.dto.BookSaveDto;
import com.library.ui.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.library.ui.domain.prototype.BookFactory.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookServiceImpl bookServiceImpl;

    List<Book> mockedList = new ArrayList<>();

    @Test
    void save_book() {
        when(bookServiceImpl.save(any(BookSaveDto.class))).thenReturn(getBookOne());
        assertThat(getBookOne()).isNotNull();
        assertThat(bookServiceImpl.save(getBookDtoOne())).isEqualTo(getBookOne());
    }

    @Test
    void findAll_books() {
        when(bookRepository.findAll()).thenReturn(getBookList());
        assertNotNull(bookRepository.findAll());
        assertThat(getBookList()).isNotNull();
        mockedList.add(getBookOne());
        mockedList.add(getBookTwo());
        assertSame(mockedList.size(), (getBookList().size()));
    }

    @Test
    void filter_books_by_genre() {
        mockedList.add(getBookOne());
        mockedList.add(getBookTwo());
        when(bookServiceImpl.filterByGenre(anyInt())).thenReturn(mockedList);
        assertThat(bookServiceImpl.filterByGenre(anyInt())).isNotNull();
        assertThat(mockedList).isNotNull().hasSize(getBookList().size());
        assertTrue(mockedList.size() > 1);
    }
}