package com.books.spring5webapp.spring5webapp.bootstrap;

import com.books.spring5webapp.spring5webapp.model.Author;
import com.books.spring5webapp.spring5webapp.model.Book;
import com.books.spring5webapp.spring5webapp.model.Publisher;
import com.books.spring5webapp.spring5webapp.repositories.AuthorRepository;
import com.books.spring5webapp.spring5webapp.repositories.BookRepository;
import com.books.spring5webapp.spring5webapp.repositories.PublisherRepository;
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
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisher.setAddress("Rua das flores");

        publisherRepository.save(publisher);

        //J.K Rolling
        Author authorJK = new Author("JK", "Rolling");
        Book bookHarry = new Book("Harry Potter", "123", publisher);
        authorJK.getBooks().add(bookHarry);
        bookHarry.getAuthors().add(authorJK);

        authorRepository.save(authorJK);
        bookRepository.save(bookHarry);

        //Machado de Assis
        Author authorMachado = new Author("Machado", "de Assis");
        Book bookMachado = new Book("Clássicos - Machado de Assis", "122", publisher);
        authorMachado.getBooks().add(bookMachado);
        bookMachado.getAuthors().add(authorMachado);

        authorRepository.save(authorMachado);
        bookRepository.save(bookMachado);
    }
}
