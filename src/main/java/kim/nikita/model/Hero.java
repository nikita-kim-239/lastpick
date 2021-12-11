/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.model;

import java.io.Serializable;


/**
 * @author Никита
 */


public class Hero extends AbstractNamedEntity implements Serializable {


    public Hero() {
    }


    public Hero(Integer id, String name) {
        super(id, name);
    }

}
