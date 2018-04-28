package com.ajaniopy.spring5webapp.bootstrap;

import com.ajaniopy.spring5webapp.model.Author;
import com.ajaniopy.spring5webapp.model.Book;
import com.ajaniopy.spring5webapp.model.Publisher;
import com.ajaniopy.spring5webapp.ropositories.AuthorRepository;
import com.ajaniopy.spring5webapp.ropositories.BookRepository;
import com.ajaniopy.spring5webapp.ropositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData()
    {
        //Eric
        Publisher dddPublisher = new Publisher("Harper Collins", "Harper Collins Address");
        publisherRepository.save(dddPublisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", dddPublisher);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);



        //Rod
        Publisher noEjbPublisher = new Publisher("Worx", "Worx Address");
        publisherRepository.save(noEjbPublisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Developement without EJB", "23444", noEjbPublisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
