package com.library.ui.service.impl;

import com.library.ui.domain.Book;
import com.library.ui.dto.BookSaveDto;
import com.library.ui.repository.BookRepository;
import com.library.ui.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(BookSaveDto model) {
//        Book book = bookRepository.findById(model.getId())
//                .orElseThrow(() -> new IllegalArgumentException("Выбран несуществующий автор"));

        Book book = new Book();
        addNewBook(model, book);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> filterByGenre(Integer genre) {
        return bookRepository.findAll(filterByCriteria(genre));
    }

    private Specification<Book> filterByCriteria(Integer genre) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("genre"), genre));
    }

    private void addNewBook(BookSaveDto model, Book book) {
        book.setBookTitle(model.getBookTitle());
        book.setGenre(model.getGenre());
        book.setPageCount(model.getPageCount());
        book.setQuantity(model.getQuantity());
        book.setPrice(model.getPrice());
        book.setDescription(model.getDescription());
        book.setPublishedYear(model.getPublishedYear());
        book.setCreatedAt(ZonedDateTime.now());
        book.setPublisher(model.getPublisher());
        book.setAuthor(model.getAuthor());
    }
}
