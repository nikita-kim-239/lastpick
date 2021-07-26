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
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;




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
    
    
    
    
  
    @PostMapping("/createFriendship")
    public View createFriendship(HttpServletRequest request) {
        
        Integer hero1=Integer.parseInt(request.getParameter("hero1"));
        Integer hero2=Integer.parseInt(request.getParameter("hero2"));
        log.info("create Friendship between "+hero1+" and "+hero2);
        heroService.createFriendship(hero1,hero2);
        
        RedirectView redirect = new RedirectView("/friendship");
        redirect.setExposeModelAttributes(false);
        return redirect;
    }
    
    
    @PostMapping("/createVictimship")
    public View createVictimship(HttpServletRequest request) {
        
        Integer predatorId=Integer.parseInt(request.getParameter("predator"));
        Integer victimId=Integer.parseInt(request.getParameter("victim"));
        log.info("create Victimship between "+predatorId+" and "+victimId);
        heroService.createVictimship(predatorId,victimId);
        
        RedirectView redirect = new RedirectView("/victimship");
        redirect.setExposeModelAttributes(false);
        return redirect;
    }
    
    
    
}
