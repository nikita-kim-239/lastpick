package kim.nikita.repository.jdbctemplate;

import kim.nikita.model.User;
import kim.nikita.repository.UserRepository;
import kim.nikita.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JdbcTemplateUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;


    private final String GET_USER_BY_LOGIN = "select * from users where username = ?";

    @Autowired
    public JdbcTemplateUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public User findByLogin(String login) {
        List<User> users = jdbcTemplate.query(GET_USER_BY_LOGIN, new UserMapper(), login);
        return (users.size() > 0) ? (User) users.get(0) : null;
    }
}
