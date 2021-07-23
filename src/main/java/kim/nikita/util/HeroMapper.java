/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import kim.nikita.model.Hero;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Никита
 */
public class HeroMapper implements RowMapper{
    
    @Override
    public Hero mapRow(ResultSet rs,int rowNum) throws SQLException
        {
            
            Hero hero=new Hero();
            hero.setId(rs.getInt("id"));
            hero.setName(rs.getString("name"));
            return hero;
        } 
}
