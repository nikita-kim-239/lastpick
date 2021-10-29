/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kim.nikita.model.*;
import kim.nikita.service.HeroService;
import kim.nikita.util.exception.AlreadyExistException;
import kim.nikita.util.exception.NoHeroesException;
import kim.nikita.util.exception.HeroNotFoundException;
import kim.nikita.util.exception.RoundCounterException;
import kim.nikita.util.exception.SameHeroesException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = RestHeroController.REST_URL,produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
public class RestHeroController {
    
    private static final Logger log = Logger.getLogger(RestHeroController.class);
    static final String REST_URL = "/rest";
    
    private final HeroService heroService;
    
    @Autowired
    public RestHeroController(HeroService heroService) {
       this.heroService = heroService;
   }
    
   @GetMapping("/heroes")
   
   public List<Hero> getAllHeroes()
    {
        log.info("Getting all Heroes");
        return heroService.getAllHeroes();
    }

    @PostMapping("/heroes")
    public Hero createHero(@RequestBody String jsonHero,HttpServletRequest request, HttpServletResponse response) throws IOException{

            ObjectMapper mapper = new ObjectMapper();
            Hero hero=new Hero();
            JsonClassWithName jsonClassWithName=new JsonClassWithName();
            try {
                 jsonClassWithName = mapper.readValue(jsonHero, JsonClassWithName.class);
            }
            catch(Exception e)
                {
                    log.error(e.getMessage());
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().println(e.getMessage());
                    response.flushBuffer();
                }
            hero.setName(jsonClassWithName.name);
            log.info("create hero with name "+hero.getName());

            return heroService.createHero(hero);

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
                                @RequestParam(name="ally4") Integer ally4,
                                HttpServletRequest request, HttpServletResponse response
                                )    throws IOException
    {
        List<Integer> friends=new ArrayList<>();
        List<Integer> enemies=new ArrayList<>();
        if (ally1!=0) friends.add(ally1);
        if (ally2!=0) friends.add(ally2);
        if (ally3!=0) friends.add(ally3);
        if (ally4!=0) friends.add(ally4);
        if (enemy1!=0) enemies.add(enemy1);
        if (enemy2!=0) enemies.add(enemy2);
        if (enemy3!=0) enemies.add(enemy3);
        if (enemy4!=0) enemies.add(enemy4);
        if (enemy5!=0) enemies.add(enemy5);

        List<Result> results=null;
        
        
        response.setCharacterEncoding("UTF-8");
        try{
        results= heroService.getResult(friends,enemies);
        }
        catch(Exception e)
        {
            
            log.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println(e.getMessage());
            response.flushBuffer();
        }

        
        return results;
    }
   
   
   
   
   
   @GetMapping("/friendship")
   
   public List<Friendship> getAllFriends()
    {
        return heroService.getAllFriends();
    }
   
    
   @PostMapping("/friendship")
   
   public List <Friendship>  createFriendship(@RequestBody String heroes,HttpServletRequest request, HttpServletResponse response) throws IOException
        {


            ObjectMapper mapper = new ObjectMapper();

            List<Friendship> result=new ArrayList<>();
            JsonClassWithId [] arrayOfHeroes=null;
            response.setCharacterEncoding("UTF-8");

            try{
                arrayOfHeroes = mapper.readValue(heroes,JsonClassWithId[].class);

                result=heroService.createFriendship(arrayOfHeroes[0].id, arrayOfHeroes[1].id);


            }
            catch(Exception e)
            {

                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }



            return  result;
        }
   
   
   @PatchMapping("/friendship")
   
   public List<Friendship>  updateFriendship(@RequestBody String friendship,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClassWithId [] arrayOfHeroes=null;
            
            response.setCharacterEncoding("UTF-8");
            
            List<Friendship> result=new ArrayList<>();
            try{
            arrayOfHeroes = mapper.readValue(friendship,JsonClassWithId[].class);
             
            
            result=heroService.updateFriendship(arrayOfHeroes[0].id,arrayOfHeroes[1].id, arrayOfHeroes[2].id);
            }
            catch(JsonProcessingException e)
            {
                e.printStackTrace();
            }
            catch(AlreadyExistException e)
            {
                
                
                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            catch (SameHeroesException e)
            {
                
                
                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            catch(HeroNotFoundException e)
            {
                
                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            
           return  result;
        }
   
   @DeleteMapping("/friendship")
   public List<Friendship>  deleteFriendship(@RequestBody String friendship,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClassWithId  json=null;
            response.setCharacterEncoding("UTF-8");
            List<Friendship> result=new ArrayList<>();
            try{
           json = mapper.readValue(friendship,JsonClassWithId.class);
            result= heroService.deleteFriendship(json.id);
            
            
            }
            catch(JsonProcessingException e)
            {
                e.printStackTrace();
            }
            catch(HeroNotFoundException e)
            {
                
                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            
           return  result;
        }
   
   
   @GetMapping("/victimship")
   
   public List<Victimship> getAllVictim()
    {
        return heroService.getAllVictims();
    }
   
    
   @PostMapping("/victimship")
   
   public List<Victimship> createVictimship(@RequestBody String heroes,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
           JsonClassWithId [] arrayOfHeroes=null;
           List <Victimship> result=new ArrayList<>();
           response.setCharacterEncoding("UTF-8");
            try{
             arrayOfHeroes = mapper.readValue(heroes,JsonClassWithId[].class);
            result= heroService.createVictimship(arrayOfHeroes[0].id, arrayOfHeroes[1].id);
            
            
            }
            catch(JsonProcessingException e)
            {
                e.printStackTrace();
            }
            catch(AlreadyExistException e)
            {
                 
                
                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            catch (RoundCounterException e)
            {
                 
                
                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            catch(SameHeroesException e)
            {
                 
                
                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            catch(HeroNotFoundException e)
            {
                
                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            
            return result;
        }
   
   @PatchMapping("/victimship")
  
   public List<Victimship>  updateVictimship(@RequestBody String victimship,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClassWithId [] arrayOfHeroes=null;
            response.setCharacterEncoding("UTF-8");
            List <Victimship> result=new ArrayList<>();
           
            try{
            arrayOfHeroes = mapper.readValue(victimship,JsonClassWithId[].class);
            result= heroService.updateVictimship(arrayOfHeroes[0].id,arrayOfHeroes[1].id, arrayOfHeroes[2].id);
            
            
            }
            catch(JsonProcessingException e)
            {
                e.printStackTrace();
            }
            catch(AlreadyExistException e)
            {
                
                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            catch(SameHeroesException e)
            {
                 
                
                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            catch(HeroNotFoundException e)
            {
                
                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            
            
            
           return  result;
        }
   
   @DeleteMapping("/victimship")
   
   public List<Victimship>  deleteVictimship(@RequestBody String victimship,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClassWithId  json=null;
            response.setCharacterEncoding("UTF-8");
           List <Victimship> result=new ArrayList<>();
            try{
           json = mapper.readValue(victimship,JsonClassWithId.class);
             result=heroService.deleteVictimship(json.id);
            
            
            }
            catch(JsonProcessingException e)
            {
                log.error(e.getMessage());
            }
            catch(HeroNotFoundException e)
            {
                
                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            
           return  result;
        }
   
   
}
