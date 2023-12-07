package com.example.course.lab6;

import static com.example.course.lab6.Process.getResult;
import static com.example.course.lab6.Process.getState;

public class Lab6Handler {
    public static String start() {
        new Thread(new Process.Supervisor()).start();
        try {
            while (getState() != State.FATAL_ERROR) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getResult();
    }
}
