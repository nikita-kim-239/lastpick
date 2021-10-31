/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.jdbctemplate;

import java.util.List;
import kim.nikita.model.Friendship;
import kim.nikita.repository.FriendshipRepository;
import kim.nikita.util.FriendshipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class JdbcTemplateFriendshipRepository implements FriendshipRepository{
    
    
    
    private final JdbcTemplate jdbcTemplate;



    
    
    private static final String SELECT_ALL_QUERY = "select F.id,F.hero1_id,F.hero2_id,H1.name as hero1_name,H2.name as hero2_name,F.friends from friendship as F join heroes as H1 on H1.id=F.hero1_id join heroes as H2 on H2.id=F.hero2_id order by H1.name,H2.name";
      private static final String INSERT_FRIENDS_QUERY = "insert into friendship (hero1_id,hero2_id,friends) values (?,?,?)";
      private static final String UPDATE_FRIENDS_QUERY = "update  friendship set hero1_id=?,hero2_id=?,friends=? where id=?";
      private static final String DELETE_FRIENDS_QUERY = "delete from  friendship  where id=?";
      private static final String SELECT_COUNT = "select count(*) from friendship where hero1_id=? and hero2_id=? or hero1_id=? and hero2_id=?";




     @Autowired
    public JdbcTemplateFriendshipRepository(JdbcTemplate jdbcTemplate) {


        this.jdbcTemplate = jdbcTemplate;       
    }

    @Override
    public List<Friendship> getAllFriends() {
       
           return jdbcTemplate.query(SELECT_ALL_QUERY,new FriendshipMapper());
    
    }

    @Override
    public void create(int hero1_id, int hero2_id,Boolean friends) {

        jdbcTemplate.update(INSERT_FRIENDS_QUERY,hero1_id,hero2_id,friends);


      
    }
    
    
    @Override
    public void update(Integer friendshipId,Integer hero1_id,Integer hero2_id,Boolean friends)
    {
        jdbcTemplate.update(UPDATE_FRIENDS_QUERY,hero1_id,hero2_id,friends,friendshipId);

    }
    

    @Override
    public int count(int hero1_id, int hero2_id) {
        return jdbcTemplate.queryForObject(SELECT_COUNT,Integer.class,hero1_id,hero2_id,hero2_id,hero1_id);
    }

    @Override
    public void delete(int friendshipId) {
         jdbcTemplate.update(DELETE_FRIENDS_QUERY,friendshipId);

    }


}
