package kim.nikita.util;

import kim.nikita.model.Combo;
import kim.nikita.model.Hero;
import java.util.*;
import java.util.stream.Collectors;


public class ComboUtil {


    public Map<String,Long> getHeroesWithComboByHero1Name(List<Hero> heroes,List<Combo> combos,String hero){
        Map<Hero,List<Combo>> combosByHero1 =combos.stream().
                collect(Collectors.groupingBy(Combo::getHero1));
        return heroes.stream().
                filter(combosByHero1::containsKey).
                collect(Collectors.toMap(Hero::getName,h->(combosByHero1.get(h).stream().filter(c1->(c1.getHero2().getName().equals(hero))).count())));
    }



}
