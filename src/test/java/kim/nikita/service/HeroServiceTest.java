/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.service;

import kim.nikita.util.exception.AlreadyExistException;
import kim.nikita.util.exception.SameHeroesException;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;



@ContextConfiguration({
    "classpath:spring/spring-app.xml",
    "classpath:spring/spring-db.xml",
    "classpath:spring/spring-mvc.xml"
//    "classpath:spring/spring-security.xml"
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
    public void testCreateFriendshipWithTheSameHeroes() {
        log.info("Testing create friendship (1,1)");
        assertThrows(SameHeroesException.class, () -> service.createFriendship(1,1,true));
    }
    
    



    @Test

    public void testCreateVictimshipAlreadyInBase() {
        log.info("Testing create friendship (1,6) already in base");
        assertThrows(AlreadyExistException.class, () -> service.createVictimship(1,6));
    }
  
    
}
