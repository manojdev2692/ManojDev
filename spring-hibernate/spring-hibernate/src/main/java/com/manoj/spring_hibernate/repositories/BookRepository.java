package com.manoj.spring_hibernate.repositories;

import com.manoj.spring_hibernate.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
