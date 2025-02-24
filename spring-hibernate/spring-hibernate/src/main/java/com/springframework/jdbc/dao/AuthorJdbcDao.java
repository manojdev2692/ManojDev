package com.springframework.jdbc.dao;

import com.springframework.jdbc.domain.AuthorJdbc;
import org.springframework.stereotype.Component;

@Component
public interface AuthorJdbcDao {

    AuthorJdbc getById(Long id);
}
