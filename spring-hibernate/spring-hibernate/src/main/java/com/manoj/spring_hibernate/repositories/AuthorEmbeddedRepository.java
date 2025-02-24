package com.manoj.spring_hibernate.repositories;

import com.manoj.spring_hibernate.model.composite.AuthorEmbedded;
import com.manoj.spring_hibernate.model.composite.NameEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameEmbeddedId> {
}
