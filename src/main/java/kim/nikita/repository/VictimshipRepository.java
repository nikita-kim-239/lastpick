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
    
    
    
    List <Victimship> getAllVictims();
    
    List <Victimship> create(int predator_id,int victim_id);
    
    int count(int predator_id,int victim_id);
    
    List <Victimship> update(int victimshipId,int predator_id, int victim_id);
    
    List <Victimship> delete(int victimshipId);
    
    
}
