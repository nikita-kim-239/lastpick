/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository;

import java.util.List;
import kim.nikita.model.Victimship;

/**
 *
 * @author Никита
 */
public interface VictimshipRepository {
    
    boolean isExist(String predator,String victim);
    
    List <Victimship> getAllVictims();
    
    void create(String predator,String victim);
}
