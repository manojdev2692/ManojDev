package com.manoj.spring_hibernate;

import com.manoj.spring_hibernate.repositories.BookRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringHibernateApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void testBookRepository() {
		long count = bookRepository.count();
		Assertions.assertTrue(count > 0);
	}

	@Test
	void contextLoads() {
	}

}
