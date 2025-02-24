package com.manoj.spring_hibernate.model.composite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name =  "author_embedded_composite")
public class AuthorEmbedded {
    @EmbeddedId
    private NameEmbeddedId id;
    private String country;

    public AuthorEmbedded() {
    }

    public AuthorEmbedded(NameEmbeddedId id) {
        this.id = id;
    }

    public NameEmbeddedId getId() {
        return id;
    }

    public void setId(NameEmbeddedId id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
