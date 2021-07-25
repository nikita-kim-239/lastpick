/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Никита
 */

@Entity
@Table(name="heroes")
@NamedQuery(name="GET_ALL_HEROES",query="SELECT h FROM Hero h ORDER BY h.name")
public class Hero extends AbstractNamedEntity implements Serializable{
    
    
    
    
    public Hero()
        {
        }
    
    
    public Hero(Integer id,String name)
        {
            super(id,name);
        }

    
    

   
   

    
   
    
    
}
