/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.repository.jpa;

import java.util.List;
import kim.nikita.model.Friendship;
import kim.nikita.repository.FriendshipRepository;

/**
 *
 * @author Никита
 */
public class JpaFriendshipRepository implements FriendshipRepository{

    @Override
    public List<Friendship> getAllFriends() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(int hero1_id, int hero2_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count(int hero1_id, int hero2_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
