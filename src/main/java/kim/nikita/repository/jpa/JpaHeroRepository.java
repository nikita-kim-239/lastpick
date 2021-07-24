/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kim.nikita.model.Hero;
import kim.nikita.repository.HeroRepository;
import org.springframework.stereotype.Repository;



@Repository
public class JpaHeroRepository implements HeroRepository{

    
    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public List<Hero> getAllHeroes() {
        return null;
    }
    
}
