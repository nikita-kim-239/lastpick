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
    
    int countOfVictims(String predatorName);
    int countOfEnemies(String victimName);
    
    List <Victimship> getAllVictims();
    Victimship create(Victimship victimship);
}
