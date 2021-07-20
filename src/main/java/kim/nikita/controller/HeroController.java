/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.controller;

import java.util.List;
import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;
import kim.nikita.model.Victimship;
import kim.nikita.service.HeroService;
import org.apache.log4j.Logger;

/**
 *
 * @author Никита
 */
public class HeroController {
    
    private HeroService heroService;
    
    private static final Logger log = Logger.getLogger(HeroController.class);
    
    
    public int getResult(String heroName)
        {
            log.info("get result for "+heroName);
            return heroService.getResult(heroName);
        }

    public List <Hero> getAllHeroes()
        {
            log.info("get all heroes");
            return heroService.getAllHeroes();
        }
    
    public List <Friendship> getAllFriends()
        {
            log.info("get all friends");
            return heroService.getAllFriends();
        }
    
    public List <Victimship> getAllVictims()
        {
            log.info("get all victioms");
            return heroService.getAllVictims();
        }
    
}
