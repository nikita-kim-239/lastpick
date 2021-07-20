/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.service;

import java.util.List;
import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;
import kim.nikita.model.Victimship;
import kim.nikita.repository.FriendshipRepository;
import kim.nikita.repository.HeroRepository;
import kim.nikita.repository.VictimshipRepository;

/**
 *
 * @author Никита
 */
public class HeroService {

    private HeroRepository heroRepository;
    private VictimshipRepository victimshipRepository;
    private FriendshipRepository friendshipRepository;
    
    
    public List <Hero> getAllHeroes()
        {
            return heroRepository.getAllHeroes();
        }
    
    
    public int getResult(String heroName)
        {
            return friendshipRepository.countOfFriends(heroName)-victimshipRepository.countOfEnemies(heroName)+victimshipRepository.countOfVictims(heroName);
        }
    
    public List <Friendship> getAllFriends()
        {
            return friendshipRepository.getAllFriends();
        }
    
    
    public List <Victimship> getAllVictims()
        {
            return victimshipRepository.getAllVictims();
        }
}
