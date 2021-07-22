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
    
    void create(int hero1_id, int hero2_id);
 
    
    int count(int hero1_id,int hero2_id);
}
