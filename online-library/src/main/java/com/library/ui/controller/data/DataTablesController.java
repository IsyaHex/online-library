package com.library.ui.controller.data;

import com.library.ui.domain.Author;
import com.library.ui.domain.Book;
import com.library.ui.domain.Publisher;
import com.library.ui.domain.User;
import com.library.ui.service.AuthorService;
import com.library.ui.service.BookService;
import com.library.ui.service.PublisherService;
import com.library.ui.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataTablesController {
    private final AuthorService authorService;
    private final BookService bookService;
    private final PublisherService publisherService;
    private final UserService userService;


    public DataTablesController(AuthorService authorService, BookService bookService,
                                PublisherService publisherService, UserService userService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.userService = userService;
    }

    @PostMapping("/ajax/users")
    public List<User> userList() {
        return userService.findAll();
    }

    @PostMapping("/ajax/publishers")
    public List<Publisher> publisherList() {
        return publisherService.findAll();
    }

    @PostMapping("/ajax/authors")
    public List<Author> authorList() {
        return authorService.findAll();
    }

    @PostMapping("/ajax/books")
    public List<Book> bookList() {
        return bookService.findAll();
    }
}
