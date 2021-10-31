package kim.nikita.repository.jdbctemplate;

import kim.nikita.model.User;
import kim.nikita.repository.UserRepository;
import kim.nikita.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcTemplateUserRepository implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    private final String GET_USER_BY_LOGIN="select * from users";

    @Autowired
    public JdbcTemplateUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;

    }

    @Override
    public User findByLogin(String login) {
        return (User)jdbcTemplate.query(GET_USER_BY_LOGIN,new UserMapper()).get(0);
    }
}
