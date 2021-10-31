/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.jdbctemplate;

import java.sql.PreparedStatement;
import java.sql.Statement;
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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Никита
 */

@Repository
public class JdbcTemplateHeroRepository implements HeroRepository{
 
        
    private final JdbcTemplate jdbcTemplate;

    
    
    private final String SELECT_ALL_HEROES="SELECT * FROM heroes ORDER BY name";
    
    private final String SELECT_COUNT="select count(*) from heroes where id=?";

    private final String SELECT_COUNT_BY_NAME="select count(*) from heroes where name=?";

    private final String SELECT_NAME="select name from heroes where id=?";

    private final String CREATE_HERO="INSERT INTO heroes (name) values (?)";



    private final String DELETE_HERO="delete from heroes where id=?";

    private final String UPDATE_HERO="update heroes set name=? where id=?";


     @Autowired
    public JdbcTemplateHeroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
       
    }
    
    
    @Override
    public List<Hero> getAllHeroes() {
        return jdbcTemplate.query(SELECT_ALL_HEROES,new HeroMapper() );
    }

    @Override
    public boolean isHeroExist(int heroId) {
        return jdbcTemplate.queryForObject(SELECT_COUNT,Integer.class,heroId)==1;
    }

    @Override
    public boolean isHeroExistWithName(String name) {
        return jdbcTemplate.queryForObject(SELECT_COUNT_BY_NAME,Integer.class,name)!=0;
    }

    @Override
    public String getHeroById(int heroId) {
       return jdbcTemplate.queryForObject(SELECT_NAME,String.class,heroId);
    }

    @Override
    public void deleteHero(int heroId) {
         jdbcTemplate.update(DELETE_HERO,heroId);
    }

    @Override
    public void createHero(Hero hero) {
        jdbcTemplate.update(CREATE_HERO,hero.getName());

    }

    @Override
    public void updateHero(Hero hero) {
        jdbcTemplate.update(UPDATE_HERO,hero.getName(),hero.getId());
    }

}
