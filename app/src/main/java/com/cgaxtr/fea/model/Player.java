package com.cgaxtr.fea.model;

/**
 * Created by Antonio on 31/07/2017.
 */

public class Player {

    private String name;
    private String lastName;
    private int points;
    private int id;

    public Player(String name, String lastName, int points, int id){
        this.name = name;
        this.lastName = lastName;
        this.points = points;
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getPoints(){
        return this.points;
    }


}
