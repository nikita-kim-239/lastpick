/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository;

import java.util.List;
import kim.nikita.model.Friendship;

/**
 *
 * @author Никита
 */
public interface FriendshipRepository {
    
    
    
    List <Friendship> getAllFriends();
    
    List<Friendship> create(int hero1_id, int hero2_id);
 
    List<Friendship> update(Integer friendshipId,Integer hero1_id,Integer hero2_id);
    
    List<Friendship> delete(int friendshipId);
    
    int count(int hero1_id,int hero2_id);
    
  
}
