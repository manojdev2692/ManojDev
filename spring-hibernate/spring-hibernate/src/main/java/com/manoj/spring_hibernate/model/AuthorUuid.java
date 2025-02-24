package com.manoj.spring_hibernate.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class AuthorUuid {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 16, nullable = false, updatable = false)
    private UUID id;

    private String firstName;
    private String lastName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
