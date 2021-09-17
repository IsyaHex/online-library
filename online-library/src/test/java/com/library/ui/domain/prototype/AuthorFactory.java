package com.library.ui.domain.prototype;

import com.library.ui.constant.GenresListEnum;
import com.library.ui.domain.Author;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class AuthorFactory {

    public static Author getAuthor() {
        Author author = new Author();
        author.setId(1L);
        author.setGenre(GenresListEnum.BILDUNGROSMAN.name());
        author.setBirthDate(LocalDate.of(1999,12,03));
        author.setAuthorsQuote("Authors Quote");
        author.setAboutAuthor("Info about author");
        author.setCreatedAt(ZonedDateTime.now());
        author.setUpdatedAt(ZonedDateTime.now());

        return author;
    }
}
