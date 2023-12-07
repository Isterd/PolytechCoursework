package com.example.course.lab4;

import com.example.course.lab4.exceptions.FileReadException;
import com.example.course.lab4.exceptions.InvalidFileFormatException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Lab4Handler {
    public static String readFile(String fileName) throws FileReadException  {
        StringBuilder result = new StringBuilder();
        try (FileReader reader = new FileReader(fileName)) {
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }
            br.close();
        }
        catch(Exception ex) {
            throw new FileReadException();
        }
        return result.toString();
    }

    public static String start(final File dictionaryPath, final File textFile) {
        StringBuilder result = new StringBuilder();
        try {
            Translator translator = new Translator(dictionaryPath.toString());
            String text = readFile(textFile.toString()).toLowerCase();
            result.append(translator.translate(text));
        } catch (FileReadException | InvalidFileFormatException e) {
            result.append(e.getMessage());
        }
        return result.toString();
    }
}
