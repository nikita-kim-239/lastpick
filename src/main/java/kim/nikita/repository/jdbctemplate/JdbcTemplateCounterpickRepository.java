/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.jdbctemplate;

import java.util.List;

import kim.nikita.model.Counterpick;
import kim.nikita.util.CounterpickMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import kim.nikita.repository.CounterpickRepository;

/**
 * @author Никита
 */

@Repository
public class JdbcTemplateCounterpickRepository implements CounterpickRepository {


    private final JdbcTemplate jdbcTemplate;


    private static final String SELECT_ALL_QUERY = "select C.id,C.predator_id,C.victim_id,H1.name as victim_name,H2.name as predator_name from counterpicks as C join heroes as H1 on H1.id=C.victim_id join heroes as H2 on H2.id=C.predator_id order by predator_name,victim_name";
    private static final String INSERT_ENEMIES_QUERY = "insert into counterpicks (predator_id,victim_id) values (?,?)";
    private static final String SELECT_COUNT = "select count(*) from counterpicks where predator_id=? and victim_id=?";
    private static final String UPDATE_ENEMIES_QUERY = "update  counterpicks set predator_id=?,victim_id=? where id=?";
    private static final String DELETE_ENEMIES_QUERY = "delete from  counterpicks  where id=?";

    @Autowired
    public JdbcTemplateCounterpickRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;

    }


    @Override
    public List<Counterpick> getAllCounterpicks() {
        return jdbcTemplate.query(SELECT_ALL_QUERY, new CounterpickMapper());
    }

    @Override
    public void create(int predator_id, int victim_id) {
        jdbcTemplate.update(INSERT_ENEMIES_QUERY, predator_id, victim_id);

    }

    @Override
    public int count(int predator_id, int victim_id) {
        return jdbcTemplate.queryForObject(SELECT_COUNT, Integer.class, predator_id, victim_id);
    }

    @Override
    public void update(int counterpicksId, int predator_id, int victim_id) {
        jdbcTemplate.update(UPDATE_ENEMIES_QUERY, predator_id, victim_id, counterpicksId);
    }

    @Override
    public void delete(int counterpicksId) {
        jdbcTemplate.update(DELETE_ENEMIES_QUERY, counterpicksId);
    }


}
