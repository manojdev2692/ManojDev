package com.manoj.spring_hibernate.repositories;

import com.manoj.spring_hibernate.model.AuthorUuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorUuidRepository extends JpaRepository<AuthorUuid, UUID> {
}
