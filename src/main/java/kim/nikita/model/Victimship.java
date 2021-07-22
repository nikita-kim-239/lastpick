/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.model;

/**
 *
 * @author Никита
 */
public class Victimship {

    private int id;

    private Hero predator;

    private Hero victim;

    public Victimship(int id,Hero predator,Hero victim)
        {
            this.id=id;
            this.predator=predator;
            this.victim=victim;
            
        }
    
    public Victimship()
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
     * @return the predator
     */
    public Hero getPredator() {
        return predator;
    }

    /**
     * @param predator the predator to set
     */
    public void setPredator(Hero predator) {
        this.predator = predator;
    }

    /**
     * @return the victim
     */
    public Hero getVictim() {
        return victim;
    }

    /**
     * @param victim the victim to set
     */
    public void setVictim(Hero victim) {
        this.victim = victim;
    }
    
    
    
    

}
