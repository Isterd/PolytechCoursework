package com.example.course.lab4.exceptions;

public class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException() {
        super("Invalid format of input file!");
    }
}