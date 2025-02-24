package com.springframework.jdbc.dao;

import com.springframework.jdbc.domain.AuthorJdbc;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorJdbcDaoImpl implements  AuthorJdbcDao{

    @Override
    public AuthorJdbc getById(Long id) {
        return null;
    }
}
