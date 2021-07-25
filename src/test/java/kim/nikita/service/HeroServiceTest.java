/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.service;

import java.util.List;
import kim.nikita.TestData;
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
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;



@ContextConfiguration({
    "classpath:spring/spring-app.xml",
    "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
public class HeroServiceTest {
    
    
    private static  Logger log;
    
    @Autowired
    private HeroService service;

    
    @Before
    public void setUp() {
        log = Logger.getLogger(HeroServiceTest.class);
    }
    
    @Test
    @Ignore
    public void testGetAllHeroes() {
        log.info("Testing get all heroes");
        
        assertEquals(TestData.heroes,service.getAllHeroes());
               
           
    }

    
    
    @Test
    @Ignore
    public void testGetFriendship() {
        log.info("Testing friendship");
        
        assertEquals(TestData.friends,service.getAllFriends());
           
    }

    

    /**
     * Test of createFriendship method, of class HeroService.
     */
    @Test
    @Ignore
    public void testCreateFriendshipWithTheSameHeroes() {
        log.info("Testing create friendship (1,1)");
        assertThrows(RuntimeException.class, () -> service.createFriendship(1,1));
    }

    /**
     * Test of createVictimship method, of class HeroService.
     */
    @Test
    @Ignore
    public void testCreateVictimshipAlreadyInBase() {
        log.info("Testing create friendship (1,6) already in base");
        assertThrows(RuntimeException.class, () -> service.createFriendship(1,6));
    }
  
    
}
