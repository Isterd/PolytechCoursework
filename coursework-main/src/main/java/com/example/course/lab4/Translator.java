package com.example.course.lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.example.course.lab4.exceptions.FileReadException;
import com.example.course.lab4.exceptions.InvalidFileFormatException;

public class Translator {

    private static final HashMap<String, String> dictionary = new HashMap<>();

    public Translator(String file) throws InvalidFileFormatException, FileReadException {
        fillDictionary(file);
    }

    public String translate(String text) {
        String[] words = Arrays.stream(text.split("\\b")).
                filter(s -> !s.equals(" ")).
                filter(s -> !s.equals("")).
                toArray(String[]::new);
        StringBuilder result = new StringBuilder();
        for (int wordCount = 0; wordCount < words.length; wordCount++) {
            if (!dictionary.containsKey(words[wordCount])) {
                result.append(words[wordCount]);
                if(!words[wordCount].matches("\\W+")) {
                    result.append(" ");
                }
                continue;
            }
            StringBuilder chain = new StringBuilder(words[wordCount]);
            while (wordCount + 1 < words.length &&
                    dictionary.containsKey(chain + " " + words[wordCount + 1])) {
                wordCount++;
                chain.append(" ").append(words[wordCount]);
            }
            result.append(dictionary.get(chain.toString()));
            if(!words[wordCount + 1].matches("\\W+")) {
                result.append(" ");
            }
        }
        text = result.toString();
        return text;
    }


    private static void fillDictionary(String fileName)
            throws InvalidFileFormatException, FileReadException {
        try(FileReader reader = new FileReader(fileName))
        {
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                String[] translateLine = line.split(" \\| ");
                try {
                    dictionary.put(
                            translateLine[0].toLowerCase(),
                            translateLine[1].toLowerCase()
                    );
                }
                catch(Exception e) {
                    throw new InvalidFileFormatException();
                }
            }
            br.close();
        } catch(Exception e) {
            if (e instanceof InvalidFileFormatException) {
                throw new InvalidFileFormatException();
            }
            throw new FileReadException();
        }
    }

}
