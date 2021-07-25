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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import kim.nikita.model.Friendship;
import kim.nikita.model.Hero;
import kim.nikita.repository.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Никита
 */

@Repository
@Transactional(readOnly = true)
public class JpaFriendshipRepository implements FriendshipRepository{

    
    private static final String GET_ALL_FRIENDS="select F.id,F.hero1_id,F.hero2_id,H1.name as hero1_name,H2.name as hero2_name from friendship as F join heroes as H1 on H1.id=F.hero1_id join heroes as H2 on H2.id=F.hero2_id order by H1.name,H2.name";
    private static final String INSERT_FRIENDS_QUERY = "insert into friendship (hero1_id,hero2_id) values (?,?)";
    private static final String SELECT_COUNT = "select count(*) from friendship where hero1_id=? and hero2_id=? or hero1_id=? and hero2_id=?";
    
   
    
    @Override
    public List<Friendship> getAllFriends() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Nikita Kim" );
	EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("GET_ALL_FRIENDS",Friendship.class).getResultList();
    }
    
    @Override
    public void create(int hero1_id, int hero2_id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Nikita Kim" );
	EntityManager em = emf.createEntityManager();
       Query query = em.createNativeQuery(INSERT_FRIENDS_QUERY);
        
        query.setParameter(1,hero1_id);
        query.setParameter(2,hero2_id);
        query.executeUpdate();
        
    }

    @Override
    public int count(int hero1_id, int hero2_id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Nikita Kim" );
	EntityManager em = emf.createEntityManager();
        Query query=em.createNamedQuery(SELECT_COUNT,Friendship.class);
        query.setParameter(1,hero1_id);
        query.setParameter(2,hero2_id);
        query.setParameter(3,hero2_id);
        query.setParameter(4,hero1_id);
        return ((Number) query.getSingleResult()).intValue();
    }
    
}
