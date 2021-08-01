/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;
import kim.nikita.model.JsonClassWithId;
import kim.nikita.model.Result;
import kim.nikita.model.Victimship;
import kim.nikita.service.HeroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = RestHeroController.REST_URL,produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
public class RestHeroController {
    
    
    static final String REST_URL = "/rest";
    
    private final HeroService heroService;
    
    @Autowired
    public RestHeroController(HeroService heroService) {
       this.heroService = heroService;
   }
    
   @GetMapping("/heroes")
   public List<Hero> getAllHeroes()
    {
        return heroService.getAllHeroes();
    }
   
   
   @GetMapping("/results")
   public List<Result> getResults(@RequestParam(name="enemy1") Integer enemy1,
                                @RequestParam(name="enemy2") Integer enemy2,
                                @RequestParam(name="enemy3") Integer enemy3,
                                @RequestParam(name="enemy4") Integer enemy4,
                                @RequestParam(name="enemy5") Integer enemy5,
                                @RequestParam(name="ally1") Integer ally1,
                                @RequestParam(name="ally2") Integer ally2,
                                @RequestParam(name="ally3") Integer ally3,
                                @RequestParam(name="ally4") Integer ally4
                                )    
    {
        List<Integer> friends=new ArrayList<>();
        List<Integer> enemies=new ArrayList<>();
        friends.add(ally1);
        friends.add(ally2);
        friends.add(ally3);
        friends.add(ally4);
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        enemies.add(enemy4);
        enemies.add(enemy5);
        return heroService.getResult(friends,enemies);
    }
   
   
   @GetMapping("/friendship")
   public List<Friendship> getAllFriends()
    {
        return heroService.getAllFriends();
    }
   
    
   @PostMapping("/friendship")
   public void createFriendship(@RequestBody String heroes)
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            try{
            JsonClassWithId [] arrayOfHeroes = mapper.readValue(heroes,JsonClassWithId[].class);
             heroService.createFriendship(arrayOfHeroes[0].id, arrayOfHeroes[1].id);
            
            
            }
            catch(JsonProcessingException e)
            {
                e.printStackTrace();
            }
            
        }
   
   
   @GetMapping("/victimship")
   public List<Victimship> getAllVictim()
    {
        return heroService.getAllVictims();
    }
   
    
   @PostMapping("/victimship")
   public void createVictimship(@RequestBody String heroes)
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            try{
            JsonClassWithId [] arrayOfHeroes = mapper.readValue(heroes,JsonClassWithId[].class);
             heroService.createVictimship(arrayOfHeroes[0].id, arrayOfHeroes[1].id);
            
            
            }
            catch(JsonProcessingException e)
            {
                e.printStackTrace();
            }
            
        }
   
   
}
