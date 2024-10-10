/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.controller;


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


    @GetMapping("/combos")
    public ModelAndView getCombos() {


        log.info("get all combos");
        ModelAndView mav = new ModelAndView("combos");
        mav.addObject("combos", heroService.getAllCombos());
        return mav;
    }


    @GetMapping("/counterpicks")
    public ModelAndView getCountepicks() {


        log.info("get all counterpicks");
        ModelAndView mav = new ModelAndView("counterpicks");
        mav.addObject("counterpicks", heroService.getAllCounterpicks());
        return mav;
    }


}
