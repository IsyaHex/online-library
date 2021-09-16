package com.library.ui.controller.assets;

import com.library.ui.constant.LanguagesListEnum;
import com.library.ui.dto.PublisherSaveDto;
import com.library.ui.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publishers")
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("publisher", new PublisherSaveDto());
        model.addAttribute("languageList", LanguagesListEnum.values());
        return "_assets/publishers";
    }
}
