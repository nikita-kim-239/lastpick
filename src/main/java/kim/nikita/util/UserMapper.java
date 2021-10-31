package kim.nikita.util;


import kim.nikita.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("username"));
        user.setPassword(rs.getString("password"));

        return user;
    }
}
