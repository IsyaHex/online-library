package com.library.ui.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "author_seq")
    @SequenceGenerator(name = "author_seq", sequenceName = "seq_author", allocationSize = 1)
    private Long id;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "book_genre")
    private String genre;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "authors_quote")
    private String authorsQuote;

    @Column(name = "about_author")
    private String aboutAuthor;

    @Column(name  = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAuthorsQuote() {
        return authorsQuote;
    }

    public void setAuthorsQuote(String authorsQuote) {
        this.authorsQuote = authorsQuote;
    }

    public String getAboutAuthor() {
        return aboutAuthor;
    }

    public void setAboutAuthor(String aboutAuthor) {
        this.aboutAuthor = aboutAuthor;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getId().equals(author.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
