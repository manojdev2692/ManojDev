package com.manoj.spring_hibernate.bootstrap;

import com.manoj.spring_hibernate.model.Author;
import com.manoj.spring_hibernate.model.AuthorUuid;
import com.manoj.spring_hibernate.model.Book;
import com.manoj.spring_hibernate.model.composite.AuthorComposite;
import com.manoj.spring_hibernate.model.composite.AuthorEmbedded;
import com.manoj.spring_hibernate.model.composite.NameEmbeddedId;
import com.manoj.spring_hibernate.model.composite.NameId;
import com.manoj.spring_hibernate.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorUuidRepository authorUuidRepository;
    private final AuthorCompositeRepository authorCompositeRepository;
    private final AuthorEmbeddedRepository authorEmbeddedRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository,
                           AuthorUuidRepository authorUuidRepository,
                           AuthorCompositeRepository authorCompositeRepository,
                           AuthorEmbeddedRepository authorEmbeddedRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.authorUuidRepository = authorUuidRepository;
        this.authorCompositeRepository = authorCompositeRepository;
        this.authorEmbeddedRepository = authorEmbeddedRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        Book bookDDD = new Book("Book 1", "123", "Publish 1");
        System.out.println(bookDDD.getId());
        Book bookDDD2 = bookRepository.save(bookDDD);
        System.out.println(bookDDD2.getId());
        Book bookSSS = new Book("Book 2", "123", "Publish 2");
        Book bookSSS2 = bookRepository.save(bookSSS);

        bookRepository.findAll().forEach(book ->
        {System.out.println("Book ID: " + book.getId());
        System.out.println("Book Title: " + book.getTitle());
        }
        );
        authorRepository.deleteAll();

        Author author1 = new Author("Manoj", "Kumar");
        System.out.println(author1.getId());
        Author author_1 = authorRepository.save(author1);
        System.out.println(author_1.getId());

        Author author2 =new Author("Vinod", "Kumar");
        Author author_2 = authorRepository.save(author2);
        authorRepository.findAll().forEach(author -> {
            System.out.println("Author ID: " + author.getId());
            System.out.println("Author Name: " + author.getFirstName()
                    + " " + author.getLastName());
        });

        authorUuidRepository.deleteAll();
        AuthorUuid authorUuid = new AuthorUuid();
        authorUuid.setFirstName("Kanti");
        authorUuid.setLastName("Devi");

        authorUuidRepository.save(authorUuid);

        AuthorUuid authorUuid2 = new AuthorUuid();
        authorUuid2.setFirstName("Vinod");
        authorUuid2.setLastName("Devi");
        authorUuidRepository.save(authorUuid2);

        authorUuidRepository.findAll().forEach(author -> {
            System.out.println("AuthorUuid ID: " + author.getId());
            System.out.println("AuthorUuid Name: " + author.getFirstName() + " " + author.getLastName());
        });
        authorCompositeRepository.deleteAll();
        AuthorComposite authorComposite1 = new AuthorComposite("Manoj", "Kumar", "India");
        authorCompositeRepository.save(authorComposite1);
        AuthorComposite authorComposite2 = new AuthorComposite("Vinod", "Kumar", "India");
        authorCompositeRepository.save(authorComposite2);
        authorCompositeRepository.findAll().forEach(authorComposite -> {
            System.out.println("AuthorComposite Name: " + authorComposite.getFirstName() + " " + authorComposite.getLastName());
        });
        Optional<AuthorComposite> authorComposite3 = authorCompositeRepository.findById(new NameId("Manoj", "Kumar"));
        System.out.println(authorComposite3.get().getFirstName());

        NameEmbeddedId nameId = new NameEmbeddedId("Dev", "Kumar");
        AuthorEmbedded authorEmbedded1 = new AuthorEmbedded(nameId);
        authorEmbedded1.setCountry("India");
        authorEmbeddedRepository.save(authorEmbedded1);
        Optional<AuthorEmbedded> authorEmbedded2 = authorEmbeddedRepository.findById(nameId);
        System.out.println("Country: " + authorEmbedded2.get().getCountry());

    }
}
