/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;
import kim.nikita.model.Result;
import kim.nikita.model.Victimship;
import kim.nikita.repository.FriendshipRepository;
import kim.nikita.repository.HeroRepository;
import kim.nikita.repository.VictimshipRepository;
import kim.nikita.util.exception.AlreadyExistException;
import kim.nikita.util.exception.NoHeroesException;
import kim.nikita.util.exception.HeroNotFoundException;
import kim.nikita.util.exception.RoundCounterException;
import kim.nikita.util.exception.SameHeroesException;
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
            
            
            Set <Integer> setOfHeroesId=new HashSet<>();
            
            for (Integer i:friends)
                {
                    setOfHeroesId.add(i);
                    if (!heroRepository.isHeroExist(i))
                        throw new HeroNotFoundException("Такого героя уже нет в базе!");
                }
            for (Integer i:enemies)
                {
                    setOfHeroesId.add(i);
                    if (!heroRepository.isHeroExist(i))
                        throw new HeroNotFoundException("Такого героя уже нет в базе!");
                }
            
            
            
            if (setOfHeroesId.isEmpty())
                throw new NoHeroesException("Выберите хотя бы одного героя!");
            
            if (setOfHeroesId.size()!=(friends.size()+enemies.size()))
                throw new SameHeroesException("Герои не должны повторяться!");
            
            
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
                    for (Integer i : friends)
                    {
                        if (arrayOfFriendship[hero.getId()][i]==1) countOfFriends++;
                    }
            //находим количество врагов среди врагов
            int countOfEnemies=0;
                    for (Integer i : enemies)
                    {
                        if (arrayOfVictimship[i][hero.getId()]==1) countOfEnemies++;
                    }
                    
            //находим количество тех врагов которые для нас жертва
            int countOfVictims=0;
                    for (Integer i : enemies)
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
            
            if (!heroRepository.isHeroExist(hero1_id))
                throw new HeroNotFoundException("Такого героя уже нет в базе!");
            if (!heroRepository.isHeroExist(hero2_id))
                throw new HeroNotFoundException("Такого героя уже нет в базе!");
            if (hero1_id==hero2_id) 
                throw new SameHeroesException("Герои не должны совпадать!");
            if (friendshipRepository.count(hero1_id, hero2_id)!=0) 
                throw new AlreadyExistException("В базе данных уже есть такая запись!");
            
             friendshipRepository.create(hero1_id,hero2_id);
        }
    
    public void updateFriendship(int friendshipId,int hero1_id,int hero2_id)
        {
            
            if (!heroRepository.isHeroExist(hero1_id))
                throw new HeroNotFoundException("Такого героя уже нет в базе!");
            if (!heroRepository.isHeroExist(hero2_id))
                throw new HeroNotFoundException("Такого героя уже нет в базе!");
            if (hero1_id==hero2_id) 
                throw new SameHeroesException("Герои не должны совпадать!");
            if (friendshipRepository.count(hero1_id, hero2_id)!=0) 
                throw new AlreadyExistException("В базе данных уже есть такая запись!");
            
             friendshipRepository.update(friendshipId,hero1_id,hero2_id);
        }
    
    public void deleteFriendship(int friendshipId)
        {
            friendshipRepository.delete(friendshipId);
        }
    
    public void createVictimship(int predator_id,int victim_id)
        {
            if (!heroRepository.isHeroExist(predator_id))
                throw new HeroNotFoundException("Такого героя уже нет в базе!");
            if (!heroRepository.isHeroExist(victim_id))
                throw new HeroNotFoundException("Такого героя уже нет в базе!");
            if (predator_id==victim_id) 
                throw new SameHeroesException("Герои не должны совпадать!");
            
            if (victimshipRepository.count(predator_id, victim_id)!=0) 
                throw new AlreadyExistException("В базе данных уже есть такая запись!");
            
            if (victimshipRepository.count(victim_id,predator_id)!=0)
                throw new RoundCounterException("Герои не должны контрить друг друга!");
            
             victimshipRepository.create(predator_id,victim_id);
        }
    
    public void updateVictimship(int victimshipId,int predator_id,int victim_id)
        {
            
            if (!heroRepository.isHeroExist(predator_id))
                throw new HeroNotFoundException("Такого героя уже нет в базе!");
            if (!heroRepository.isHeroExist(victim_id))
                throw new HeroNotFoundException("Такого героя уже нет в базе!");
            
            if (predator_id==victim_id) 
                throw new SameHeroesException("Герои не должны совпадать!");
            if (victimshipRepository.count(predator_id, victim_id)!=0) 
                throw new AlreadyExistException("В базе данных уже есть такая запись!");
            if (victimshipRepository.count(victim_id,predator_id)!=0)
                throw new RoundCounterException("Герои не должны контрить друг друга!");
            
             victimshipRepository.update(victimshipId,predator_id,victim_id);
        }
    
    public void deleteVictimship(int victimshipId)
        {
            victimshipRepository.delete(victimshipId);
        }
    
}
