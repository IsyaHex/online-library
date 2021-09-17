package com.library.ui.domain.prototype;

import com.library.ui.domain.Book;
import com.library.ui.dto.BookSaveDto;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.library.ui.domain.prototype.AuthorFactory.getAuthor;
import static com.library.ui.domain.prototype.PublisherFactory.getPublisher;

public class BookFactory {

    public static Book getBookOne() {
        Book book = new Book();
        book.setId(1L);
        book.setBookTitle("Title One");
        book.setGenre("Genre One");
        book.setPageCount(250);
        book.setQuantity(25);
        book.setPrice(25.00);
        book.setDescription("Description One");
        book.setPublishedYear(1991);
        book.setCreatedAt(ZonedDateTime.now());
        book.setUpdatedAt(ZonedDateTime.now());
        book.setPublisher(getPublisher());
        book.setAuthor(getAuthor());

        return book;
    }

    public static Book getBookTwo() {
        Book book = new Book();
        book.setId(2L);
        book.setBookTitle("Title Two");
        book.setGenre("Genre Two");
        book.setPageCount(350);
        book.setQuantity(35);
        book.setPrice(35.00);
        book.setDescription("Description Two");
        book.setPublishedYear(2001);
        book.setCreatedAt(ZonedDateTime.now());
        book.setUpdatedAt(ZonedDateTime.now());
        book.setPublisher(getPublisher());
        book.setAuthor(getAuthor());

        return book;
    }

    public static List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(getBookOne());
        bookList.add(getBookTwo());

        return bookList;
    }

    public static BookSaveDto getBookDtoOne() {
        BookSaveDto bookDto = new BookSaveDto();
        bookDto.setBookTitle("Book Dto Title");
        bookDto.setGenre("Book Dto Genre");
        bookDto.setPageCount(450);
        bookDto.setQuantity(45);
        bookDto.setPrice(45.00);
        bookDto.setDescription("Book Dto Description");
        bookDto.setPublishedYear(2011);
        bookDto.setCreatedAt(ZonedDateTime.now());
        bookDto.setUpdatedAt(ZonedDateTime.now());
        bookDto.setPublisher(getPublisher());
        bookDto.setAuthor(getAuthor());

        return bookDto;
    }

}
