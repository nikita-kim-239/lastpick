/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Никита
 */
@Entity
@Table(name="friendship")
@NamedQuery(name="GET_ALL_FRIENDS",query="select f from Friendship f join f.hero1 h1 join f.hero2 h2 where h1.id=:f.hero1_id and h2.id=:f.hero2_id")
public class Friendship extends AbstractBaseEntity implements Serializable{
    

      @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn (name="hero1_id")
    private Hero hero1;
    
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn (name="hero2_id")
    private Hero hero2;


    private Integer positionInTable;

    public Integer getPositionInTable() {
        return positionInTable;
    }

    public void setPositionInTable(Integer positionInTable) {
        this.positionInTable = positionInTable;
    }

    public Friendship(int id, Hero hero1, Hero hero2)
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
