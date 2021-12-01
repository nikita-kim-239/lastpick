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

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class RootController {


    private static final Logger log = Logger.getLogger(RootController.class);

    @Autowired
    HeroService heroService;

    @GetMapping("/")
    public String root() {
        log.info("get index");
        return "index";
    }


    @GetMapping("/heroes")
    public ModelAndView getHeroes() {
        log.info("get heroes");
        ModelAndView mav = new ModelAndView("heroes");
        mav.addObject("heroes", heroService.getAllHeroes());
        return mav;
    }


    @GetMapping("/friendship")
    public ModelAndView getFriendship() {


        log.info("get all  friends");
        ModelAndView mav = new ModelAndView("friends");
        mav.addObject("friendships", heroService.getAllFriends());
        return mav;
    }


    @GetMapping("/victimship")
    public ModelAndView getVictimship() {


        log.info("get all  victims");
        ModelAndView mav = new ModelAndView("victims");
        mav.addObject("victimships", heroService.getAllVictims());
        return mav;
    }


}
