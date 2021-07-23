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
public class Hero {
    
    
    private Integer id;
    private String name;
    
    
    public Hero()
        {
        }
    
    public Hero(int id,String name)
        {
            this.id=id;
            this.name=name;
        }

    
    public int getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString()
        {
            return " { "+id+" "+name+" } ";
        }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hero that = (Hero) o;
        return id != null && id==that.id&&name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
    
}
