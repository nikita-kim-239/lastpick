/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.datajpa;

import kim.nikita.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Никита
 */
public interface CrudHeroRepository extends JpaRepository<Hero,Integer>{
    
}
