/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.datajpa;

import java.util.List;
import kim.nikita.model.Hero;
import kim.nikita.repository.HeroRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Никита
 */

@Repository
public class DataJpaHeroRepository implements HeroRepository{

    private final CrudHeroRepository crudRepository;
    
    
    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");
    
    public DataJpaHeroRepository(CrudHeroRepository crudRepository)
        {
            this.crudRepository=crudRepository;
        }
    
    @Override
    public List<Hero> getAllHeroes() {
        return crudRepository.findAll(SORT_NAME);
    }
    
}
