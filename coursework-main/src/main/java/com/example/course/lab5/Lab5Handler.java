package com.example.course.lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Lab5Handler {

    public static String start(int functionNumber, String input, Character startLetter) {
        try {
            return switch (functionNumber) {
                case 1 -> getFirstFunctionResult(input);
                case 2 -> getSecondFunctionResult(input);
                case 3 -> getThirdFunctionResult(input);
                case 4 -> getFourthFunctionResult(input, startLetter);
                case 5 -> getFifthFunctionResult(input);
                case 6 -> getSixthFunctionResult(input);
                case 7 -> getSeventhFunctionResult(input);
                default -> "Something went wrong";
            };
        }
        catch (WrongTypeException e) {
            return e.getMessage();
        }
    }

    private static String getFirstFunctionResult(String input) throws WrongTypeException {
        StringBuilder result = new StringBuilder();
        try {
            final List<Integer> list1 = Arrays.stream(input.split(" "))
                    .map(Integer::parseInt).toList();
            result.append(Methods.task1(list1)).append("\n");
        }
        catch (NumberFormatException e) {
            result.append(e.getMessage());
        }
        return result.toString();
    }

    private static String getSecondFunctionResult(String input) {
        StringBuilder result = new StringBuilder();
        final List<String> list2 = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());
        result.append(Methods.task2(list2)).append("\n");
        return result.toString();
    }

    private static String getThirdFunctionResult(String input) throws WrongTypeException {
        StringBuilder result = new StringBuilder();
        try {
            final List<Double> list3 = Arrays.stream(input.split(" "))
                            .map(Double::parseDouble)
                            .collect(Collectors.toList());
            result.append(Methods.task3(list3)).append("\n");
        }
        catch (NumberFormatException  e) {
            result.append(e.getMessage());
        }
        return result.toString();
    }

    private static String getFourthFunctionResult(String input, Character startLetter) {
        StringBuilder result = new StringBuilder();
        final List<String> list4 = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());
        result.append(Methods.task4(list4, startLetter)).append("\n");
        return result.toString();
    }

    private static String getFifthFunctionResult(String input) {
        StringBuilder result = new StringBuilder();
        final List<String> list5 = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());
        try {
            result.append(Methods.task5(list5)).append("\n");
        } catch (NoSuchElementException e) {
            result.append(e.getMessage());
        }
        return result.toString();
    }

    private static String getSixthFunctionResult(String input) throws WrongTypeException {
        String[] data = input.split(" ");
        final int[] array6 = new int[data.length];
        try {
            for (int i = 0; i < data.length; i++) {
                array6[i] = Integer.parseInt(data[i]);
            }
        }
        catch (NumberFormatException  e) {
            return e.getMessage();
        }
        return String.valueOf(Methods.task6(array6));
    }

    private static String getSeventhFunctionResult(String input) {
        StringBuilder result = new StringBuilder();
        final List<String> list7 = Arrays.stream(input.split(" ")).toList();
        result.append(Methods.task7(list7)).append("\n");
        return result.toString();
    }
}
