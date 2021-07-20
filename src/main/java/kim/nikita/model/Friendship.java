/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.model;

import java.io.Serializable;

/**
 *
 * @author Никита
 */
public class Friendship implements Serializable{
    
    private int id;
    
    private String hero1;
    private String hero2;

    
    public Friendship(int id,String hero1,String hero2)
        {
            this.id=id;
            this.hero1=hero1;
            this.hero2=hero2;
        }
    
    public Friendship()
        {
        }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the hero1
     */
    public String getHero1() {
        return hero1;
    }

    /**
     * @param hero1 the hero1 to set
     */
    public void setHero1(String hero1) {
        this.hero1 = hero1;
    }

    /**
     * @return the hero2
     */
    public String getHero2() {
        return hero2;
    }

    /**
     * @param hero2 the hero2 to set
     */
    public void setHero2(String hero2) {
        this.hero2 = hero2;
    }
    
    
    
}
