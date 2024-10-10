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

import kim.nikita.model.Combo;
import kim.nikita.model.Counterpick;
import kim.nikita.model.Hero;
import kim.nikita.model.Result;
import kim.nikita.repository.HeroRepository;
import kim.nikita.util.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kim.nikita.repository.CounterpickRepository;
import kim.nikita.repository.ComboRepository;


@Service
public class HeroService {


    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private CounterpickRepository counterpickRepository;
    @Autowired
    private ComboRepository comboRepository;


    public void createHero(Hero hero) {

      
        if ((hero.getName().length() < 2) || (hero.getName().length() > 30))
            throw new BadNameException("Плохое имя!");

        heroRepository.createHero(hero);


    }

    public void deleteHero(Integer heroId) {
        heroRepository.deleteHero(heroId);
    }

    public void updateHero(Hero hero) {

     
        if ((hero.getName().length() < 2) || (hero.getName().length() > 30))
            throw new BadNameException("Плохое имя!");
        heroRepository.updateHero(hero);
    }


    public List<Hero> getAllHeroes() {
        return heroRepository.getAllHeroes();
    }


    public List<Result> getResult(List<Integer> friends, List<Integer> enemies) {


        Set<Integer> setOfHeroesId = new HashSet<>();

        for (Integer i : friends) {
            setOfHeroesId.add(i);
            if (!heroRepository.isHeroExist(i))
                throw new HeroNotFoundException("Такого героя уже нет в базе!");
        }
        for (Integer i : enemies) {
            setOfHeroesId.add(i);
            if (!heroRepository.isHeroExist(i))
                throw new HeroNotFoundException("Такого героя уже нет в базе!");
        }


        if (setOfHeroesId.isEmpty())
            throw new NoHeroesException("Выберите хотя бы одного героя!");

        if (setOfHeroesId.size() != (friends.size() + enemies.size()))
            throw new SameHeroesException("Герои не должны повторяться!");


        List<Result> results = new ArrayList<>();
        List<Combo> combo = comboRepository.getAllCombos();
        List<Counterpick> counterpick = counterpickRepository.getAllCounterpicks();
        List<Hero> heroes = heroRepository.getAllHeroes();

        Integer maxHeroId = 0;

        for (Hero hero : heroes) {
            if (hero.getId() > maxHeroId)
                maxHeroId = hero.getId();
        }

        maxHeroId++;

        int[][] arrayOfCombo = new int[maxHeroId][maxHeroId];

        int[][] arrayOfCounterpick = new int[maxHeroId][maxHeroId];

        for (Combo f : combo) {

            arrayOfCombo[f.getHero1().getId()][f.getHero2().getId()] = 1;
            arrayOfCombo[f.getHero2().getId()][f.getHero1().getId()] = 1;


        }

        for (Counterpick v : counterpick) {
            arrayOfCounterpick[v.getPredator().getId()][v.getVictim().getId()] = 1;

        }
        //фильтруем список героев, чтобы в него не входили исходные герои
        List<Hero> filteredHeroes = heroes.stream().filter(h -> (!friends.contains(h.getId())) && (!enemies.contains(h.getId()))).collect(Collectors.toList());

        for (Hero hero : filteredHeroes) {
            //находим количество союзников среди друзей
            int countOfCombos = 0;
            for (Integer i : friends) {
                countOfCombos += arrayOfCombo[hero.getId()][i];
            }
            //находим количество врагов среди врагов
            int countOfEnemies = 0;
            for (Integer i : enemies) {
                if (arrayOfCounterpick[i][hero.getId()] == 1) countOfEnemies++;
            }

            //находим количество тех врагов которые для нас жертва
            int countOfCounterpicks = 0;
            for (Integer i : enemies) {
                if (arrayOfCounterpick[hero.getId()][i] == 1) countOfCounterpicks++;
            }

            results.add(new Result(hero.getName(), countOfCombos - countOfEnemies + countOfCounterpicks));
        }

        results.sort(Comparator.comparing(o -> o.getScore()));
        Collections.reverse(results);
        return results;
    }

    public List<Combo> getAllCombos() {
        return comboRepository.getAllCombos();
    }


    public List<Counterpick> getAllCounterpicks() {
        return counterpickRepository.getAllCounterpicks();
    }

    public void createCombo(int hero1_id, int hero2_id) {


        if (hero1_id == hero2_id)
            throw new SameHeroesException("Герои не должны совпадать!");
        

        comboRepository.create(hero1_id, hero2_id);


    }

    public void updateCombo(Integer comboId, Integer hero1_id, Integer hero2_id) {


        if (hero1_id.equals(hero2_id))
            throw new SameHeroesException("Герои не должны совпадать!");
        

        comboRepository.update(comboId, hero1_id, hero2_id);

    }

    public void deleteCombo(int comboId) {
        comboRepository.delete(comboId);
    }

    public void createCounterpick(int predator_id, int victim_id) {

        if (predator_id == victim_id)
            throw new SameHeroesException("Герои не должны совпадать!");

        

        if (counterpickRepository.count(victim_id, predator_id) != 0)
            throw new RoundCounterException("Герои не должны контрить друг друга!");

        counterpickRepository.create(predator_id, victim_id);
    }

    public void updateCounterpick(int counterpickId, int predator_id, int victim_id) {
        if (predator_id == victim_id)
            throw new SameHeroesException("Герои не должны совпадать!");
        
        if (counterpickRepository.count(victim_id, predator_id) != 0)
            throw new RoundCounterException("Герои не должны контрить друг друга!");

        counterpickRepository.update(counterpickId, predator_id, victim_id);
    }

    public void deleteCounterpick(int counterpickId) {
        counterpickRepository.delete(counterpickId);
    }

}
