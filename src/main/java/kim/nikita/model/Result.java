/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim.nikita.model;

import java.io.Serializable;


public class Result implements Serializable{
    
    public Result(String name,int score)
        {   
            this.name=name;
            this.score=score;
        }
    
    public Result()
        {
        }
    
    private String name;
    
    private int score;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    @Override
    public String toString()
        {
            return " { "+name+":"+score+" } ";
        }
    
}

