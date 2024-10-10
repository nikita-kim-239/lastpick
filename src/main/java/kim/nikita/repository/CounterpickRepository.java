/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository;

import java.util.List;

import kim.nikita.model.Counterpick;

/**
 * @author Никита
 */
public interface CounterpickRepository {


    List<Counterpick> getAllCounterpicks();

    void create(int predator_id, int victim_id);

    int count(int predator_id, int victim_id);

    void update(int victimshipId, int predator_id, int victim_id);

    void delete(int counterpickId);


}
