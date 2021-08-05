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

import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;
import kim.nikita.model.JsonClassWithId;
import kim.nikita.model.Result;
import kim.nikita.model.Victimship;
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
        System.out.println("enemies: "+enemies);
        System.out.println("friends: "+friends);
        List<Result> results=null;
        
        
        response.setCharacterEncoding("UTF-8");
        try{
        results= heroService.getResult(friends,enemies);
        }
        catch(NoHeroesException e)
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
        
        return results;
    }
   
   
   
   
   
   @GetMapping("/friendship")
   
   public List<Friendship> getAllFriends()
    {
        return heroService.getAllFriends();
    }
   
    
   @PostMapping("/friendship")
   
   public List<JsonClassWithId>  createFriendship(@RequestBody String heroes,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClassWithId [] arrayOfHeroes=null;
            
            response.setCharacterEncoding("UTF-8");
            
            try{
            arrayOfHeroes = mapper.readValue(heroes,JsonClassWithId[].class);
             heroService.createFriendship(arrayOfHeroes[0].id, arrayOfHeroes[1].id);
            
            
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
            
            
           return  Arrays.asList(arrayOfHeroes);
        }
   
   
   @PatchMapping("/friendship")
   
   public List<JsonClassWithId>  updateFriendship(@RequestBody String friendship,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClassWithId [] arrayOfHeroes=null;
            
            response.setCharacterEncoding("UTF-8");
            
            try{
            arrayOfHeroes = mapper.readValue(friendship,JsonClassWithId[].class);
             heroService.updateFriendship(arrayOfHeroes[0].id,arrayOfHeroes[1].id, arrayOfHeroes[2].id);
            
            
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
            
           return  Arrays.asList(arrayOfHeroes);
        }
   
   @DeleteMapping("/friendship")
   
   public JsonClassWithId  deleteFriendship(@RequestBody String friendship,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClassWithId  json=null;
            response.setCharacterEncoding("UTF-8");
            try{
           json = mapper.readValue(friendship,JsonClassWithId.class);
             heroService.deleteFriendship(json.id);
            
            
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
            
           return  json;
        }
   
   
   @GetMapping("/victimship")
   
   public List<Victimship> getAllVictim()
    {
        return heroService.getAllVictims();
    }
   
    
   @PostMapping("/victimship")
   
   public List<JsonClassWithId> createVictimship(@RequestBody String heroes,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
           JsonClassWithId [] arrayOfHeroes=null;
           
           response.setCharacterEncoding("UTF-8");
            try{
             arrayOfHeroes = mapper.readValue(heroes,JsonClassWithId[].class);
             heroService.createVictimship(arrayOfHeroes[0].id, arrayOfHeroes[1].id);
            
            
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
            
            return Arrays.asList(arrayOfHeroes);
        }
   
   @PatchMapping("/victimship")
  
   public List<JsonClassWithId>  updateVictimship(@RequestBody String victimship,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClassWithId [] arrayOfHeroes=null;
            response.setCharacterEncoding("UTF-8");
           
            try{
            arrayOfHeroes = mapper.readValue(victimship,JsonClassWithId[].class);
             heroService.updateVictimship(arrayOfHeroes[0].id,arrayOfHeroes[1].id, arrayOfHeroes[2].id);
            
            
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
            
            
            
           return  Arrays.asList(arrayOfHeroes);
        }
   
   @DeleteMapping("/victimship")
   
   public JsonClassWithId  deleteVictimship(@RequestBody String victimship,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClassWithId  json=null;
            response.setCharacterEncoding("UTF-8");
           
            try{
           json = mapper.readValue(victimship,JsonClassWithId.class);
             heroService.deleteVictimship(json.id);
            
            
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
            
           return  json;
        }
   
   
}
