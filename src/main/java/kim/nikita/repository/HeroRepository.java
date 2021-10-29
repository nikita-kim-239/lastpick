/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository;

import java.util.List;
import kim.nikita.model.Hero;

/**
 *
 * @author Никита
 */
public interface HeroRepository {
    
    
    List <Hero> getAllHeroes();
    
    boolean isHeroExist (int heroId);

    boolean isHeroExistWithName(String name);
    
    String  getHeroById(int heroId);

    Hero createHero(Hero hero);

    
}
