package com.manoj.spring_hibernate.repositories;

import com.manoj.spring_hibernate.model.composite.AuthorComposite;
import com.manoj.spring_hibernate.model.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
