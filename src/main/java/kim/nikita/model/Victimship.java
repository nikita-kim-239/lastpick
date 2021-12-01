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


public class Victimship extends AbstractBaseEntity {


    private Hero predator;


    private Hero victim;

    public Victimship(int id, Hero predator, Hero victim) {
        this.id = id;
        this.predator = predator;
        this.victim = victim;

    }

    public Victimship() {
    }


    public Hero getPredator() {
        return predator;
    }


    public void setPredator(Hero predator) {
        this.predator = predator;
    }


    public Hero getVictim() {
        return victim;
    }


    public void setVictim(Hero victim) {
        this.victim = victim;
    }


}
