/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.jdbctemplate;

import java.util.List;
import javax.sql.DataSource;
import kim.nikita.model.Hero;
import kim.nikita.repository.HeroRepository;
import kim.nikita.util.HeroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Никита
 */

@Repository
public class JdbcTemplateHeroRepository implements HeroRepository{
 
        
    private final JdbcTemplate jdbcTemplate;

    
    
    private final String SELECT_ALL_HEROES="SELECT * FROM heroes ORDER BY name";
    
     @Autowired
    public JdbcTemplateHeroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
       
    }
    
    
    @Override
    public List<Hero> getAllHeroes() {
        return jdbcTemplate.query(SELECT_ALL_HEROES,new HeroMapper() );
    }
    
}
