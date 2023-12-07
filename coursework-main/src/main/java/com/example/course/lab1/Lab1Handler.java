package com.example.course.lab1;

public class Lab1Handler {
    private static final String COMMAND_ERROR = "Incorrect command, try again";

    public static String start(String name, String command) {
        MoveStrategy defaultMove = new Walk();
        final Hero MY_PERSON = new Hero(name, defaultMove);
        String result = "";
        switch (command) {
            case "walk" -> {
                MY_PERSON.setMoveStrategy(new Walk());
                result = MY_PERSON.move();
            }
            case "ride" -> {
                MY_PERSON.setMoveStrategy(new Ride());
                result = MY_PERSON.move();
            }
            case "fly" -> {
                MY_PERSON.setMoveStrategy(new Fly());
                result = MY_PERSON.move();
            }
            default -> {
                return COMMAND_ERROR;
            }
        }
        return result;
    }
}
