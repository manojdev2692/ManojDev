package com.manoj.spring_hibernate;

import com.manoj.spring_hibernate.model.Book;
import com.manoj.spring_hibernate.repositories.BookRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.manoj.spring_hibernate.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJpaTestSlice {

    @Autowired
    private BookRepository bookRepository;

    @Commit
    @Order(1)
    @Test
    public void testBookRepository() {
        long count = bookRepository.count();
        bookRepository.save(new Book("Book 3", "678", "Publisher 3"));
        long count2 = bookRepository.count();

        Assertions.assertTrue(count < count2);
    }

    @Order(1)
    @Test
    public void testJpaTestSpliceTransaction(){
        long count = bookRepository.count();
        Assertions.assertEquals(1, count);
    }

}
