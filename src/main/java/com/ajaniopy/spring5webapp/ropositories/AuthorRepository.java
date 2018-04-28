package com.ajaniopy.spring5webapp.ropositories;

import com.ajaniopy.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
