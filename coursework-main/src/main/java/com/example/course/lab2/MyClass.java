package com.example.course.lab2;

public class MyClass {

    @MyAnnotation(1)
    private static String firstCall() {
        return "Я первый вызов\n";
    }

    @MyAnnotation(2)
    private static String secondCall(String str) {
        return str + "\n";
    }

    private static String thirdCall() {
        return "Я третий вызов\n";
    }

    @MyAnnotation()
    private static String fourthCall(String str) {
        return "Я четвертый вызов " + str + "\n";
    }

    @MyAnnotation(4)
    public static String fifthCall() {
        return "Я пятый вызов\n";
    }

    @MyAnnotation(3)
    protected static String diffType(double a, byte b, boolean c) {
        return "{" + a + ", " + b + ", " + c + "}\n";
    }

    @MyAnnotation(4)
    private static String getMultiplication(int a, float b) {
        return a + " * " + b + " = " + (a * b) + "\n";
    }
}