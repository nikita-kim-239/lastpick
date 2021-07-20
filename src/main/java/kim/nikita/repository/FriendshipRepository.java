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
    
    int countOfFriends(String heroName);
    
    List <Friendship> getAllFriends();
    
    Friendship create(String heroName1, String heroName2);
    
}
