package com.library.ui.service.impl;

import com.library.ui.domain.Author;
import com.library.ui.dto.AuthorSaveDto;
import com.library.ui.repository.AuthorRepository;
import com.library.ui.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(AuthorSaveDto model) {
        Author author = new Author();
        addNewAuthor(model, author);
        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    private void addNewAuthor(AuthorSaveDto model, Author author) {
        author.setAuthorName(model.getAuthorName());
        author.setGenre(model.getGenre());
        author.setBirthDate(model.getBirthDate());
        author.setAuthorsQuote(model.getAuthorsQuote());
        author.setAboutAuthor(model.getAboutAuthor());
        author.setCreatedAt(ZonedDateTime.now());
    }
}
