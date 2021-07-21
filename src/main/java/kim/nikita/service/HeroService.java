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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HeroService {

    
    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private VictimshipRepository victimshipRepository;
    @Autowired
    private FriendshipRepository friendshipRepository;
    
    
    public List <Hero> getAllHeroes()
        {
            return heroRepository.getAllHeroes();
        }
    
    
    public int getResult(String heroName,List<String> friends,List<String> enemies)
        {
            //находим количество союзников среди друзей
            int countOfFriends=0;            
            for (String friend:friends)
                {
                    if (friendshipRepository.isFriends(heroName,friend)) countOfFriends++;
                }
            //находим количество врагов среди врагов
            int countOfEnemies=0;
            for (String enemy:enemies)
                {
                    if (victimshipRepository.isExist(enemy,heroName)) countOfEnemies++;
                }
            //находим количество тех врагов которые для нас жертва
            int countOfVictims=0;
            for (String enemy:enemies)
                {
                    if (victimshipRepository.isExist(heroName,enemy)) countOfVictims++;
                }
            return countOfFriends-countOfEnemies+countOfVictims;
        }
    
    public List <Friendship> getAllFriends()
        {
            return friendshipRepository.getAllFriends();
        }
    
    
    public List <Victimship> getAllVictims()
        {
            return victimshipRepository.getAllVictims();
        }
    
    public void createFriendship(String hero1,String hero2)
        {
             friendshipRepository.create(hero1,hero2);
        }
    
    public void createVictimship(String predator,String victim)
        {
             victimshipRepository.create(predator,victim);
        }
}
