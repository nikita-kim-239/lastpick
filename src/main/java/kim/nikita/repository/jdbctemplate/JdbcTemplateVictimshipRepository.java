/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.jdbctemplate;

import java.util.List;
import kim.nikita.model.Victimship;
import kim.nikita.repository.VictimshipRepository;
import kim.nikita.util.VictimshipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Никита
 */

@Repository
public class JdbcTemplateVictimshipRepository implements VictimshipRepository{

    
    private final JdbcTemplate jdbcTemplate;

   
    
    
    
    private static final String SELECT_ALL_QUERY = "select V.id,V.predator_id,V.victim_id,H1.name as victim_name,H2.name as predator_name from victimship as V join heroes as H1 on H1.id=V.victim_id join heroes as H2 on H2.id=V.predator_id order by predator_name,victim_name";
      private static final String INSERT_ENEMIES_QUERY = "insert into victimship (predator_id,victim_id) values (?,?)";
      private static final String SELECT_COUNT = "select count(*) from victimship where predator_id=? and victim_id=?";
    private static final String UPDATE_ENEMIES_QUERY = "update  victimship set predator_id=?,victim_id=? where id=?";
      private static final String DELETE_ENEMIES_QUERY = "delete from  victimship  where id=?";
      
      @Autowired
    public JdbcTemplateVictimshipRepository(JdbcTemplate jdbcTemplate) {
 
        this.jdbcTemplate = jdbcTemplate;
        
    }
      
      
    @Override
    public List<Victimship> getAllVictims() {
       return jdbcTemplate.query(SELECT_ALL_QUERY,new VictimshipMapper());
    }

    @Override
    public void create(int predator_id, int victim_id) {
        jdbcTemplate.update(INSERT_ENEMIES_QUERY,predator_id,victim_id);

    }

    @Override
    public int count(int predator_id, int victim_id) {
        return jdbcTemplate.queryForObject(SELECT_COUNT,Integer.class,predator_id,victim_id);
    }

    @Override
    public void update(int victimshipId,int predator_id,int victim_id)
    {
        jdbcTemplate.update(UPDATE_ENEMIES_QUERY,predator_id,victim_id,victimshipId);
    }

    @Override
    public void delete(int victimshipId) {
       jdbcTemplate.update(DELETE_ENEMIES_QUERY,victimshipId);
    }
    
    
    
}
