/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.model;


import javax.persistence.*;
import org.springframework.util.Assert;


@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractBaseEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    
    protected AbstractBaseEntity()
        {
        }
    
    protected AbstractBaseEntity(Integer id) {
        this.id = id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    // doesn't work for hibernate lazy proxy
    public int id() {
        Assert.notNull(id, "Entity must has id");
        return id;
    }
    public boolean isNew() {
        return this.id == null;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return id != null && id.equals(that.id);
    }
    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
    
}
