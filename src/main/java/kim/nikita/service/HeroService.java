/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;
import kim.nikita.model.Result;
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
    
    
    public List <Result> getResult(List<Integer> friends,List<Integer> enemies)
        {
            
            
            List <Result> results=new ArrayList<>();
            List <Friendship> friendship=friendshipRepository.getAllFriends();
            List <Victimship> victimship=victimshipRepository.getAllVictims();
            List <Hero> heroes=heroRepository.getAllHeroes();
            
            int length=heroes.size()+1;
            int [][] arrayOfFriendship=new int[length][length];
            
            int [][] arrayOfVictimship=new int[length][length];
            
            
            
            
            for (Friendship f:friendship)
                {
                    arrayOfFriendship[f.getHero1().getId()][f.getHero2().getId()]=1;
                    arrayOfFriendship[f.getHero2().getId()][f.getHero1().getId()]=1;
                }
           
            for (Victimship v:victimship)
                {
                    arrayOfVictimship[v.getPredator().getId()][v.getVictim().getId()]=1;
                    
                }
            
            List <Hero> filteredHeroes=heroes.stream().filter(h->(!friends.contains(h.getId()))&&(!enemies.contains(h.getId()))).collect(Collectors.toList());
            
            for (Hero hero:filteredHeroes)
            {
            //находим количество союзников среди друзей
            int countOfFriends=0;        
                    for (int i=1;i<length;i++)
                    {
                        if (arrayOfFriendship[hero.getId()][i]==1) countOfFriends++;
                    }
            //находим количество врагов среди врагов
            int countOfEnemies=0;
                    for (int i=1;i<length;i++)
                    {
                        if (arrayOfVictimship[i][hero.getId()]==1) countOfEnemies++;
                    }
                    
            //находим количество тех врагов которые для нас жертва
            int countOfVictims=0;
                    for (int i=1;i<length;i++)
                    {
                        if (arrayOfVictimship[hero.getId()][i]==1) countOfVictims++;
                    }
            
            results.add(new Result(hero.getName(),countOfFriends-countOfEnemies+countOfVictims));
            }
            
            results.sort(Comparator.comparing(o->o.getScore()));
            Collections.reverse(results);
            return results;
        }
    
    public List <Friendship> getAllFriends()
        {
            return friendshipRepository.getAllFriends();
        }
    
    
    public List <Victimship> getAllVictims()
        {
            return victimshipRepository.getAllVictims();
        }
    
    public void createFriendship(int hero1_id,int hero2_id)
        {
             friendshipRepository.create(hero1_id,hero2_id);
        }
    
    public void createVictimship(int predator_id,int victim_id)
        {
             victimshipRepository.create(predator_id,victim_id);
        }
}
