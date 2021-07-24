/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.jpa;

import java.util.List;
import kim.nikita.model.Victimship;
import kim.nikita.repository.VictimshipRepository;

/**
 *
 * @author Никита
 */
public class JpaVictimshipRepository implements VictimshipRepository{

    @Override
    public List<Victimship> getAllVictims() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(int predator_id, int victim_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count(int predator_id, int victim_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
