package com.library.ui.controller.assets;

import com.library.ui.constant.GenresListEnum;
import com.library.ui.constant.LanguagesListEnum;
import com.library.ui.domain.Book;
import com.library.ui.dto.BookSaveDto;
import com.library.ui.service.AuthorService;
import com.library.ui.service.BookService;
import com.library.ui.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private static final String url = "http://localhost:9999/books";

    public BookController(BookService bookService, AuthorService authorService, PublisherService publisherService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("book", new BookSaveDto());
        model.addAttribute("publishersList", publisherService.findAll());
        model.addAttribute("authorsList", authorService.findAll());
        model.addAttribute("genresList", GenresListEnum.values());
        return "_assets/books";
    }

    @RequestMapping(value = "/newBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute(name = "book") BookSaveDto book, Model model) {
        return newBook(book, model, bookService, publisherService, authorService, url);
    }

    public static String newBook(@ModelAttribute(name = "book") BookSaveDto book, Model model, BookService bookService, PublisherService publisherService, AuthorService authorService, String url) {
        bookService.save(book);
        model.addAttribute("book", book);
        model.addAttribute("publishersList", publisherService.findAll());
        model.addAttribute("authorsList", authorService.findAll());
        model.addAttribute("genresList", GenresListEnum.values());
        return "redirect:" + url;
    }

//    @PostMapping("/filter/{genre}")
//    public List<Book> bookListByGenre(@PathVariable Integer genre) {
//        return bookService.filterByGenre(genre);
//    }

}
