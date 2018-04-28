package com.ajaniopy.spring5webapp.ropositories;

import com.ajaniopy.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

}
