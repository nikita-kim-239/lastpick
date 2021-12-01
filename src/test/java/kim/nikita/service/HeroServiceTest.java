/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.service;

import kim.nikita.model.Hero;
import kim.nikita.model.Result;
import kim.nikita.util.exception.AlreadyExistException;
import kim.nikita.util.exception.BadNameException;
import kim.nikita.util.exception.SameHeroesException;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml",
        "classpath:spring/spring-mvc.xml"

})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class HeroServiceTest {


    private static Logger log;

    @Autowired
    private HeroService service;


    @Before
    public void setUp() {
        log = Logger.getLogger(HeroServiceTest.class);
    }


    @Test
    public void getResultsWithAbaddonInEnemies() {

        List<Integer> enemies = new ArrayList<>();
        enemies.add(1);
        List<Integer> friends = new ArrayList<>();
        long actual = service.getResult(friends, enemies).stream().filter(r -> r.getScore() != 0).count();
        assertEquals(21, actual);

    }

    @Test
    public void testCreateHero() {
        Hero newHero = new Hero(123, "new");
        service.createHero(newHero);
        List<Hero> heroes = service.getAllHeroes();
        assertEquals(123, heroes.size());
    }

    @Test
    public void testCreateHeroWithBadName() {
        Hero newHero = new Hero(123, "a");
        assertThrows(BadNameException.class, () -> service.createHero(newHero));
    }

    @Test
    public void testDeleteHero() {
        service.deleteHero(100);
        List<Hero> heroes = service.getAllHeroes();
        assertEquals(121, heroes.size());
    }

    @Test
    public void testUpdateHeroWithBadName() {
        assertThrows(BadNameException.class, () -> service.updateHero(new Hero(100, "a")));
    }

    @Test
    public void testUpdateHeroAlreadyExist() {
        assertThrows(AlreadyExistException.class, () -> service.updateHero(new Hero(27, "Doom")));
    }


    @Test
    public void testGetAllHeroes() {
        List<Hero> heroes = service.getAllHeroes();
        assertEquals(122, heroes.size());
    }

    @Test
    public void getResultWithSameHeroes() {
        List<Integer> enemies = new ArrayList<>();
        enemies.add(1);
        List<Integer> friends = new ArrayList<>();
        friends.add(1);
        assertThrows(SameHeroesException.class, () -> service.getResult(friends, enemies));

    }


    @Test
    public void testCreateFriendshipWithTheSameHeroes() {
        log.info("Testing create friendship (1,1)");
        assertThrows(SameHeroesException.class, () -> service.createFriendship(1, 1, true));
    }


    @Test
    public void testCreateVictimshipAlreadyInBase() {
        log.info("Testing create friendship (1,6) already in base");
        assertThrows(AlreadyExistException.class, () -> service.createVictimship(1, 6));
    }


}
