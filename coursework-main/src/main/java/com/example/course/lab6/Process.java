package com.example.course.lab6;

import java.util.Random;

public class Process {
    private static State state = State.RUNNING;
    private static final Object monitor = new Object();
    private static final Thread abstractProgram = new Thread(new AbstractProgram());

    private static final StringBuffer RESULT = new StringBuffer();

    public static String getResult() {
        return RESULT.toString();
    }

    public static State getState() {
        return state;
    }

    static class AbstractProgram implements Runnable {
        @Override
        public void run() {
            Thread daemon = new Thread(() -> {
                while (true) {
                    Utils.pause(1000, 5000);
                    if (abstractProgram.isInterrupted()) {
                        break;
                    }
                    synchronized (monitor) {
                        state = State.values()[new Random().nextInt(State.values().length)];
                        if (state.equals(State.RUNNING)) {
                            RESULT.append("Демон: Программе повезло и состояние осталось RUNNING\n");
                        } else {
                            RESULT.append("Демон: Я изменил состояние программы на: ").append(state.toString()).append("\n");
                        }
                        monitor.notify();
                    }
                }
            });
            daemon.setDaemon(true);
            daemon.start();
            RESULT.append("Абстрактная программа: я заработала и запустила демона!\n");
        }
    }

    static class Supervisor implements Runnable {

        @Override
        public void run() {
            RESULT.append("Супервизор: я встал!");
            abstractProgram.start();
            while (!abstractProgram.isInterrupted()) {
                synchronized (monitor) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    switch (state) {
                        case FATAL_ERROR -> stopProgram();
                        case UNKNOWN, STOPPING -> runProgram();
                        default -> RESULT.append("Супервизор: Я ничего не сделал)\n");
                    }
                }
            }
        }

        private void runProgram() {
            state = State.RUNNING;
            RESULT.append("Супервизор: Я перезапустил программу\n");
        }

        private void stopProgram() {
            abstractProgram.interrupt();
            RESULT.append("Супервизор: Я остановил программу\n");
        }
    }
}
