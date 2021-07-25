/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import kim.nikita.model.Hero;
import kim.nikita.repository.HeroRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional(readOnly = true)
public class JpaHeroRepository implements HeroRepository{

   
    private static final String GET_ALL_HEROES="select * from heroes order by name";
    
    
    
    
    
    @Override
    public List<Hero> getAllHeroes() {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Nikita Kim" );
	EntityManager em = emf.createEntityManager();
        
        return em.createNativeQuery(GET_ALL_HEROES,Hero.class).getResultList();
        
    }
    
}
