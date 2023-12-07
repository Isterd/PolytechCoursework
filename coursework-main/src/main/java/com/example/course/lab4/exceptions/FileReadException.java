package com.example.course.lab4.exceptions;

public class FileReadException extends Exception {

    public FileReadException() {
        super("Unable to read current file!");
    }
}