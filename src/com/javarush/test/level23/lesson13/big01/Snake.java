package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by Golitsyn.SN on 19.05.2016.
 */
public class Snake {
    ArrayList<SnakeSection> sections;
    boolean isAlive;
    SnakeDirection direction;

    public ArrayList<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public SnakeDirection getDirection() {

        return direction;
    }

    public Snake(int x,int y) {
        sections = new ArrayList<>();
        SnakeSection head = new SnakeSection(x,y);
        sections.add(head);
        isAlive=true;
    }
    int getX(){
        return sections.get(0).getX();
    }
    int getY(){
        return sections.get(0).getY();
    }
    public void move(){}
}
