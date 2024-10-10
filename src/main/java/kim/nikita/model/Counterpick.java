/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kim.nikita.model;


public class Counterpick extends AbstractBaseEntity {


    private Hero predator;


    private Hero victim;



    public Counterpick() {
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
