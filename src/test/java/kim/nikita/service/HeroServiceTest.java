/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.service;

import java.util.List;
import kim.nikita.controller.HeroController;
import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;
import kim.nikita.model.Result;
import kim.nikita.model.Victimship;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;



@ContextConfiguration({
    "classpath:spring/spring-app.xml",
    
})
@RunWith(SpringRunner.class)
public class HeroServiceTest {
    
    
    private static final Logger log = Logger.getLogger(HeroServiceTest.class);
    
    @Autowired
    private HeroService service;

    
    @Test
    public void testGetAllHeroes() {
        
    }

    /**
     * Test of getResult method, of class HeroService.
     */
    @Test
    public void testGetResult() {
        
    }

    /**
     * Test of getAllFriends method, of class HeroService.
     */
    @Test
    public void testGetAllFriends() {
        
    }

    /**
     * Test of getAllVictims method, of class HeroService.
     */
    @Test
    public void testGetAllVictims() {
   
    }

    /**
     * Test of createFriendship method, of class HeroService.
     */
    @Test
    public void testCreateFriendshipWithTheSameHeroes() {
        log.info("Testing create friendship (1,1)");
        assertThrows(RuntimeException.class, () -> service.createFriendship(1,1));
    }

    /**
     * Test of createVictimship method, of class HeroService.
     */
    @Test
    public void testCreateVictimshipAlreadyInBase() {
        log.info("Testing create friendship (1,6) already in base");
        assertThrows(RuntimeException.class, () -> service.createFriendship(1,6));
    }
    
}
