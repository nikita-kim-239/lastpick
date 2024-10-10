/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import kim.nikita.model.Hero;
import kim.nikita.model.Counterpick;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author Никита
 */
public class CounterpickMapper implements RowMapper {

    @Override
    public Counterpick mapRow(ResultSet rs, int rowNum) throws SQLException {

        Counterpick counterpick = new Counterpick();
        counterpick.setId(rs.getInt("id"));
        Hero predator = new Hero();
        predator.setId(rs.getInt("predator_id"));
        predator.setName(rs.getString("predator_name"));
        counterpick.setPredator(predator);
        Hero victim = new Hero();
        victim.setId(rs.getInt("victim_id"));
        victim.setName(rs.getString("victim_name"));
        counterpick.setVictim(victim);
        return counterpick;
    }


}
