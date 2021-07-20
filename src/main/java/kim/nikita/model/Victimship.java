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

    private String predator;

    private String victim;

    public Victimship(int id,String predator,String victim)
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
    public String getPredator() {
        return predator;
    }

    /**
     * @param predator the predator to set
     */
    public void setPredator(String predator) {
        this.predator = predator;
    }

    /**
     * @return the victim
     */
    public String getVictim() {
        return victim;
    }

    /**
     * @param victim the victim to set
     */
    public void setVictim(String victim) {
        this.victim = victim;
    }

}
