package com.books.spring5webapp.spring5webapp.bootstrap;

import com.books.spring5webapp.spring5webapp.model.Author;
import com.books.spring5webapp.spring5webapp.model.Book;
import com.books.spring5webapp.spring5webapp.repositories.AuthorRepository;
import com.books.spring5webapp.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        //J.K Rolling
        Author authorJK = new Author("JK", "Rolling");
        Book bookHarry = new Book("Harry Potter", "123", "JK.Rolling");
        authorJK.getBooks().add(bookHarry);
        bookHarry.getAuthors().add(authorJK);

        authorRepository.save(authorJK);
        bookRepository.save(bookHarry);

        //Machado de Assis
        Author authorMachado = new Author("Machado", "de Assis");
        Book bookMachado = new Book("Clássicos - Machado de Assis", "122", "Machado de Assis");
        authorMachado.getBooks().add(bookMachado);
        bookMachado.getAuthors().add(authorMachado);

        authorRepository.save(authorMachado);
        bookRepository.save(bookMachado);
    }
}
