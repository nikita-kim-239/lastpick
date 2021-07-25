/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import kim.nikita.model.Result;
import kim.nikita.service.HeroService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class RootController {
    
    
    private static final Logger log = Logger.getLogger(RootController.class);
    
    @Autowired
    HeroService heroService;
    
    @GetMapping("/")
    public String root()
        {
            log.info("get index");
            return "index";
        }
    
    
      
    
    
    @GetMapping("/friendship")
    public ModelAndView getFriendship() {
        
        
        log.info("get all  friends");
        ModelAndView mav = new ModelAndView("friends");
        mav.addObject("friends",heroService.getAllFriends());
        return mav;
    }
    
    @GetMapping("/createFriendship")
    public String getFriendForm()
        {
            log.info("create Friendship");
            return "friendForm";
        }
    
    @GetMapping("/victimship")
    public ModelAndView getVictimship() {
        
        
        log.info("get all  victims");
        ModelAndView mav = new ModelAndView("victims");
        mav.addObject("victims",heroService.getAllVictims());
        return mav;
    }
    
    @GetMapping("/createVictimship")
    public String getVictimForm()
        {
            log.info("get VictimForm");
            return "victimForm";
        }
    
    
    @PostMapping("/results")
    public ModelAndView getResult(
                HttpServletRequest request
                ) {
        
        List <Integer> friends = new ArrayList<>();
        friends.add(Integer.parseInt(request.getParameter("ally1")));
        friends.add(Integer.parseInt(request.getParameter("ally2")));
        friends.add(Integer.parseInt(request.getParameter("ally3")));
        friends.add(Integer.parseInt(request.getParameter("ally4")));
       
        List <Integer> enemies = new ArrayList<>();
        enemies.add(Integer.parseInt(request.getParameter("enemy1")));
        enemies.add(Integer.parseInt(request.getParameter("enemy2")));
        enemies.add(Integer.parseInt(request.getParameter("enemy3")));
        enemies.add(Integer.parseInt(request.getParameter("enemy4")));
        enemies.add(Integer.parseInt(request.getParameter("enemy5")));
        log.info("get all  result");
        ModelAndView mav = new ModelAndView("results");
        mav.addObject("results",heroService.getResult(friends,enemies));
        return mav;
    }
    
  
    
    
    
    
    
    
    
}
