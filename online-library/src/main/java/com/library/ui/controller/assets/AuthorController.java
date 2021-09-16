package com.library.ui.controller.assets;

import com.library.ui.constant.GenresListEnum;
import com.library.ui.dto.AuthorSaveDto;
import com.library.ui.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private static final String url = "http://localhost:9999/authors";

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("author", new AuthorSaveDto());
        model.addAttribute("genresList", GenresListEnum.values());
        return "_assets/authors";
    }

    @RequestMapping(value = "/newAuthor", method = RequestMethod.POST)
    public String addBook(@ModelAttribute(name = "author") AuthorSaveDto author, Model model) {
        authorService.save(author);
        model.addAttribute("author", author);
        return "redirect:" + url;
    }
}



//TODO...

//1.Проставить эндпоинты
//2.Фронтовая часть
//    а) Стили, логотипы, задние фоны
//    б) .html файлы