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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kim.nikita.model.*;
import kim.nikita.service.HeroService;
import kim.nikita.util.exception.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://lastpick.herokuapp.com", maxAge = 3600)
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


    @PostMapping("/admin/heroes")
    public List<Hero> createHero(@RequestBody String jsonHero,HttpServletRequest request, HttpServletResponse response) throws IOException{

            ObjectMapper mapper = new ObjectMapper();
            Hero hero=new Hero();
            response.setCharacterEncoding("UTF-8");
            JsonClass jsonClass=new JsonClass();
            try {
                 jsonClass = mapper.readValue(jsonHero, JsonClass.class);
            }
            catch(JsonProcessingException e)
                {
                    log.debug(e.getMessage());
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().println(e.getMessage());
                    response.flushBuffer();
                }

            hero.setName(jsonClass.name);
            log.info("create hero with name "+hero.getName());
            try {
                heroService.createHero(hero);
            }
            catch(BadNameException e1)
            {
                log.debug(e1.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e1.getMessage());
                response.flushBuffer();
            }
            catch (AlreadyExistException e2) {
                log.debug(e2.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e2.getMessage());
                response.flushBuffer();
            }
            return getAllHeroes();

        }

    @PatchMapping("/admin/heroes")
    public List<Hero> updateHero(@RequestBody String jsonHero,HttpServletRequest request, HttpServletResponse response) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Hero hero=new Hero();
        response.setCharacterEncoding("UTF-8");
        JsonClass jsonClass=new JsonClass();
        try {
            jsonClass = mapper.readValue(jsonHero, JsonClass.class);
        }
        catch(JsonProcessingException e)
        {
            log.debug(e.getMessage());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println(e.getMessage());
            response.flushBuffer();
        }


        hero.setId(jsonClass.id);
        hero.setName(jsonClass.name);
        try {
            heroService.updateHero(hero);
        }
        catch(BadNameException e1)
        {
            log.debug(e1.getMessage());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println(e1.getMessage());
            response.flushBuffer();
        }
        catch (AlreadyExistException e2)
        {
            log.debug(e2.getMessage());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println(e2.getMessage());
            response.flushBuffer();
        }
        log.info("update hero with id "+hero.getId()+" to name "+hero.getName());
        return getAllHeroes();
    }

    @DeleteMapping("/admin/heroes")
    public List<Hero> deleteHero(@RequestBody String json,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
            response.setCharacterEncoding("UTF-8");
            JsonClass jsonClass=null;

            ObjectMapper objectMapper=new ObjectMapper();
            try{
                jsonClass=objectMapper.readValue(json,JsonClass.class);

            }
            catch(JsonProcessingException e)
                {
                    e.printStackTrace();
                }
            try {
                heroService.deleteHero(jsonClass.id);
            }
            catch(HeroNotFoundException e)
            {
                log.debug(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }
            return getAllHeroes();
        }
   
   
   @GetMapping("/results")
   public List<Result> getResults(@RequestParam(value="enemy1", required=true) String enemy1,
                                  @RequestParam(value="enemy2", required=true) String enemy2,
                                  @RequestParam(value="enemy3", required=true) String enemy3,
                                  @RequestParam(value="enemy4", required=true) String enemy4,
                                  @RequestParam(value="enemy5", required=true) String enemy5,
                                  @RequestParam(value="ally1", required=true) String ally1,
                                  @RequestParam(value="ally2", required=true) String ally2,
                                  @RequestParam(value="ally3", required=true) String ally3,
                                  @RequestParam(value="ally4", required=true) String ally4,
                                  HttpServletRequest request, HttpServletResponse response
                                )    throws IOException
    {
        List<Integer> friends=new ArrayList<>();
        List<Integer> enemies=new ArrayList<>();


            Integer enemy1Id=Integer.parseInt(enemy1);
            Integer enemy2Id=Integer.parseInt(enemy2);
            Integer enemy3Id=Integer.parseInt(enemy3);
            Integer enemy4Id=Integer.parseInt(enemy4);
            Integer enemy5Id=Integer.parseInt(enemy5);
            Integer ally1Id=Integer.parseInt(ally1);
            Integer ally2Id=Integer.parseInt(ally2);
            Integer ally3Id=Integer.parseInt(ally3);
            Integer ally4Id=Integer.parseInt(ally4);






            if (enemy1Id!=0) enemies.add(enemy1Id);
            if (enemy2Id!=0) enemies.add(enemy2Id);
            if (enemy3Id!=0) enemies.add(enemy3Id);
            if (enemy4Id!=0) enemies.add(enemy4Id);
            if (enemy5Id!=0) enemies.add(enemy5Id);
            if (ally1Id!=0) friends.add(ally1Id);
            if (ally2Id!=0) friends.add(ally2Id);
            if (ally3Id!=0) friends.add(ally3Id);
            if (ally4Id!=0) friends.add(ally4Id);








        List<Result> results=null;
        
        
        response.setCharacterEncoding("UTF-8");
        try{
        results= heroService.getResult(friends,enemies);
        }
        catch(Exception e)
        {
            
            log.debug(e.getMessage());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println(e.getMessage());
            response.flushBuffer();
        }

        
        return results;
    }
   
   
   
   
   
   @GetMapping("/admin/friendship")
   public List<Friendship> getAllFriends()
    {
        return heroService.getAllFriends();
    }
   
    
   @PostMapping("/admin/friendship")
   public List <Friendship>  createFriendship(@RequestBody String heroes,HttpServletRequest request, HttpServletResponse response) throws IOException
        {


            ObjectMapper mapper = new ObjectMapper();


            JsonClass [] arrayOfHeroes=null;
            response.setCharacterEncoding("UTF-8");

            try{
                arrayOfHeroes = mapper.readValue(heroes,JsonClass[].class);

                heroService.createFriendship(arrayOfHeroes[0].id, arrayOfHeroes[1].id,arrayOfHeroes[2].friends);


            }
            catch(Exception e)
            {

                log.error(e.getMessage());
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println(e.getMessage());
                response.flushBuffer();
            }



            return  getAllFriends();
        }
   
   
   @PatchMapping("/admin/friendship")
   public List<Friendship>  updateFriendship(@RequestBody String friendship,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClass [] arrayOfHeroes=null;
            
            response.setCharacterEncoding("UTF-8");
            

            try{
            arrayOfHeroes = mapper.readValue(friendship,JsonClass[].class);
             
            
            heroService.updateFriendship(arrayOfHeroes[0].id,arrayOfHeroes[1].id, arrayOfHeroes[2].id,arrayOfHeroes[3].friends);
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

           return  getAllFriends();
        }
   
   @DeleteMapping("/admin/friendship")
   public List<Friendship>  deleteFriendship(@RequestBody String friendship,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClass  json=null;
            response.setCharacterEncoding("UTF-8");

            try{
           json = mapper.readValue(friendship,JsonClass.class);
            heroService.deleteFriendship(json.id);
            
            
            }
            catch(JsonProcessingException e)
            {
                e.printStackTrace();
            }

            
           return  getAllFriends();
        }
   
   
   @GetMapping("/admin/victimship")
   
   public List<Victimship> getAllVictims()
    {
        return heroService.getAllVictims();
    }
   
    
   @PostMapping("/admin/victimship")
   
   public List<Victimship> createVictimship(@RequestBody String heroes,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
           JsonClass [] arrayOfHeroes=null;

           response.setCharacterEncoding("UTF-8");
            try{
             arrayOfHeroes = mapper.readValue(heroes,JsonClass[].class);
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

            
            return getAllVictims();
        }
   
   @PatchMapping("/admin/victimship")
  
   public List<Victimship>  updateVictimship(@RequestBody String victimship,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClass [] arrayOfHeroes=null;
            response.setCharacterEncoding("UTF-8");

           
            try{
            arrayOfHeroes = mapper.readValue(victimship,JsonClass[].class);
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

           return  getAllVictims();
        }
   
   @DeleteMapping("/admin/victimship")
   
   public List<Victimship>  deleteVictimship(@RequestBody String victimship,HttpServletRequest request, HttpServletResponse response) throws IOException
        {
             
            
            ObjectMapper mapper = new ObjectMapper();
            JsonClass  json=null;
            response.setCharacterEncoding("UTF-8");
            try{

            json = mapper.readValue(victimship,JsonClass.class);
            heroService.deleteVictimship(json.id);
            
            
            }
            catch(JsonProcessingException e)
            {
                log.error(e.getMessage());
            }

            
           return  getAllVictims();
        }
   
   
}
