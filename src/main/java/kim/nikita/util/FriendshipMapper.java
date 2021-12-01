/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author Никита
 */
public class FriendshipMapper implements RowMapper {


    @Override
    public Friendship mapRow(ResultSet rs, int rowNum) throws SQLException {

        Friendship friendship = new Friendship();

        friendship.setId(rs.getInt("id"));

        Hero hero1 = new Hero();

        hero1.setId(rs.getInt("hero1_id"));
        hero1.setName(rs.getString("hero1_name"));
        friendship.setHero1(hero1);
        Hero hero2 = new Hero();

        hero2.setId(rs.getInt("hero2_id"));
        hero2.setName(rs.getString("hero2_name"));
        friendship.setHero2(hero2);

        friendship.setFriends(rs.getBoolean("friends"));

        return friendship;
    }

}
