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
    
    boolean isFriends(String hero1,String hero2);
    
    List <Friendship> getAllFriends();
    
    void create(String hero1, String hero2);
    
}
