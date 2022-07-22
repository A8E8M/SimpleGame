package com.SG;

import jdk.swing.interop.SwingInterOpUtils;

public class Player {
    private final String name;
    private int score = 0;
    public Player (String name){
        this.name = name;
    }
    public String getName () {
        return name;
    }
    public int getScore (){
        return score;
    }
    public void outputScore () {
        System.out.println("Игрок: "+name+". Счет: "+ score+".");
    }
    public void setScore (int score){
        this.score += score;
    }


}
