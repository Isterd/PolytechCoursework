package com.example.course;

import java.io.File;

import com.example.course.lab4.Lab4Handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class Lab4Controller {
    private static final String PATH_DICT = "C:\\Users\\User\\IdeaProjects\\lab4\\dictionary.txt";
    private static final String PATH_TEXT = "C:\\Users\\User\\IdeaProjects\\lab4\\text.txt";

    @FXML
    private TextArea dictionaryPathInput;

    @FXML
    private Button executeBtn;

    @FXML
    private ImageView homeBtn;

    @FXML
    private TextArea outputLabel;

    @FXML
    private TextArea textPathInput;

    @FXML
    public void initialize() {
        outputLabel.setText("");
        executeBtn.setOnAction(e -> {
            outputLabel.setText(Lab4Handler.start(new File(dictionaryPathInput.getText()), new File(textPathInput.getText())));
        });
        homeBtn.setOnMouseClicked(SwitcherController::switchToHome);
        dictionaryPathInput.setText(PATH_DICT);
        textPathInput.setText(PATH_TEXT);
    }
}
