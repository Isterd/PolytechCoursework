package com.example.course.lab1;

public class Hero {
    private final String name;
    private MoveStrategy moveStrategy;

    public Hero(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    String move() {
        return name + " " + moveStrategy.move();
    }
}
