package com.library.ui.repository;

import com.library.ui.domain.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @EntityGraph(attributePaths = {"author", "publisher"})
    List<Book> findAll();

    List<Book> findAll(Specification<Book> criteria);
}