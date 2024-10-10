/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.jdbctemplate;

import java.util.List;

import kim.nikita.model.Combo;
import kim.nikita.util.ComboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import kim.nikita.repository.ComboRepository;


@Repository
public class JdbcTemplateComboRepository implements ComboRepository {


    private final JdbcTemplate jdbcTemplate;


    private static final String SELECT_ALL_QUERY = "select C.id,C.hero1_id,C.hero2_id,H1.name as hero1_name,H2.name as hero2_name from combos as C join heroes as H1 on H1.id=C.hero1_id join heroes as H2 on H2.id=C.hero2_id order by H1.name,H2.name";
    private static final String INSERT_COMBO_QUERY = "insert into combos (hero1_id,hero2_id) values (?,?)";
    private static final String UPDATE_COMBO_QUERY = "update  combos set hero1_id=?,hero2_id=? where id=?";
    private static final String DELETE_COMBO_QUERY = "delete from  combos  where id=?";
    private static final String SELECT_COUNT = "select count(*) from combos where hero1_id=? and hero2_id=? or hero1_id=? and hero2_id=?";


    @Autowired
    public JdbcTemplateComboRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Combo> getAllCombos() {
        return jdbcTemplate.query(SELECT_ALL_QUERY, new ComboMapper());

    }

    @Override
    public void create(int hero1_id, int hero2_id) {
        jdbcTemplate.update(INSERT_COMBO_QUERY, hero1_id, hero2_id);
    }


    @Override
    public void update(Integer comboId, Integer hero1_id, Integer hero2_id) {
        jdbcTemplate.update(UPDATE_COMBO_QUERY, hero1_id, hero2_id, comboId);

    }


    @Override
    public int count(int hero1_id, int hero2_id) {
        return jdbcTemplate.queryForObject(SELECT_COUNT, Integer.class, hero1_id, hero2_id, hero2_id, hero1_id);
    }

    @Override
    public void delete(int comboId) {
        jdbcTemplate.update(DELETE_COMBO_QUERY, comboId);

    }


}
