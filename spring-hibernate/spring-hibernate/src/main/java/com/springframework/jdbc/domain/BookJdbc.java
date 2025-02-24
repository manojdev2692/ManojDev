package com.springframework.jdbc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class BookJdbc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    private String publisher;

    public BookJdbc() {
    }

    public BookJdbc(String title, String publisher, String isbn) {
        this.title = title;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof BookJdbc bookJdbc)) return false;

        return Objects.equals(id, bookJdbc.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
