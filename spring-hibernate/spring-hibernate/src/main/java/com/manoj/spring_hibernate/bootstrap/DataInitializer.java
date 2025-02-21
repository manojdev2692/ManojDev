package com.manoj.spring_hibernate.bootstrap;

import com.manoj.spring_hibernate.model.Book;
import com.manoj.spring_hibernate.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
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
    }
}
