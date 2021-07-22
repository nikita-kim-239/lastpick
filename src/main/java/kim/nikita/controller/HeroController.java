/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.controller;

import java.util.List;
import java.util.stream.Collectors;
import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;
import kim.nikita.model.Result;
import kim.nikita.model.Victimship;
import kim.nikita.service.HeroService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
public class HeroController {
    
    
    @Autowired
    private HeroService heroService;
    
    private static final Logger log = Logger.getLogger(HeroController.class);
    
    
    public List<Result> getResult(List<Integer> friends,List<Integer> enemies)
        {
            log.info("get results");
            
            return heroService.getResult(friends,enemies);
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
    
    
    public void createFriendship(int hero1_id,int hero2_id)
        {
            log.info("create friendship between "+hero1_id+" "+hero2_id);
            heroService.createFriendship(hero1_id,hero2_id);
        }
    
    public void createVictimship(int predator,int victim)
        {
            log.info("create victimship between "+predator+" "+victim);
            heroService.createVictimship(predator,victim);
        }
    
}
