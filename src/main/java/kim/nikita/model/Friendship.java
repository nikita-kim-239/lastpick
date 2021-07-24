/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.model;

import java.io.Serializable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author Никита
 */
public class Friendship extends AbstractBaseEntity implements Serializable{
    

    @ManyToOne(fetch = FetchType.LAZY)
    private Hero hero1;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Hero hero2;

    
    public Friendship(int id,Hero hero1,Hero hero2)
        {
            this.id=id;
            this.hero1=hero1;
            this.hero2=hero2;
        }
    
    public Friendship()
        {
        }
    
   
    
    public Hero getHero1() {
        return hero1;
    }

    /**
     * @param hero1 the hero1 to set
     */
    public void setHero1(Hero hero1) {
        this.hero1 = hero1;
    }

    /**
     * @return the hero2
     */
    public Hero getHero2() {
        return hero2;
    }

    /**
     * @param hero2 the hero2 to set
     */
    public void setHero2(Hero hero2) {
        this.hero2 = hero2;
    }
    
    
    
}
