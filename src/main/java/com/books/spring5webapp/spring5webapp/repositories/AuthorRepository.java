package com.books.spring5webapp.spring5webapp.repositories;

import com.books.spring5webapp.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
