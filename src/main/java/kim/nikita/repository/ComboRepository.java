/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository;

import java.util.List;

import kim.nikita.model.Combo;

/**
 * @author Никита
 */
public interface ComboRepository {


    List<Combo> getAllCombos();

    void create(int hero1_id, int hero2_id);

    void update(Integer comboId, Integer hero1_id, Integer hero2_id);

    void delete(int comboId);

    int count(int hero1_id, int hero2_id);


}
