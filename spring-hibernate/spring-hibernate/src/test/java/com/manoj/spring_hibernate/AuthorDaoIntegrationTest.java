package com.manoj.spring_hibernate;

import com.springframework.jdbc.dao.AuthorJdbcDao;
import com.springframework.jdbc.domain.AuthorJdbc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.springframework.jdbc.dao"})
@Import(AuthorJdbcDao.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthorDaoIntegrationTest {

    private AuthorJdbcDao authorJdbcDao;

    @Test
    public void test() {
        AuthorJdbc author = authorJdbcDao.getById(1L);
        Assertions.assertNotNull(author);
    }
}
