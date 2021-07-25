/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Никита
 */
public class Victimship extends AbstractBaseEntity{

   
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="predator_id")
    private Hero predator;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="victim_id")
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
