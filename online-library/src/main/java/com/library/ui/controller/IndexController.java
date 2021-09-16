package com.library.ui.controller;

import com.library.ui.constant.GenresListEnum;
import com.library.ui.constant.LanguagesListEnum;
import com.library.ui.dto.BookSaveDto;
import com.library.ui.service.AuthorService;
import com.library.ui.service.BookService;
import com.library.ui.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.library.ui.controller.assets.BookController.newBook;

@Controller
@RequestMapping({"/", "/index"})
public class IndexController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private static final String url = "http://localhost:9999/";

    public IndexController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("book", new BookSaveDto());
        model.addAttribute("publishersList", publisherService.findAll());
        model.addAttribute("authorsList", authorService.findAll());
        model.addAttribute("genresList", GenresListEnum.values());
        model.addAttribute("languagesList", LanguagesListEnum.values());
        return "index";
    }

    @RequestMapping(value = "/newBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute(name = "book") BookSaveDto book, Model model) {
        return newBook(book, model, bookService, publisherService, authorService, url);
    }
}
