/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




public abstract class AbstractNamedEntity extends AbstractBaseEntity{
    

    protected String name;
    
    protected AbstractNamedEntity() {
    }
    
    protected AbstractNamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return super.toString() + '(' + name + ')';
    }
    
}
