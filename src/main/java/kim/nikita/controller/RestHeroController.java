/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.controller;

import java.util.List;
import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;
import kim.nikita.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = RestHeroController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
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
   
   
    
}
