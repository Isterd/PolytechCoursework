package com.example.course;

import com.example.course.lab6.Lab6Handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Lab6Controller {

    @FXML
    private Button executeBtn;

    @FXML
    private TextArea outputLabel;

    @FXML
    private ImageView homeBtn;

    @FXML
    private Text textHint;

    @FXML
    public void initialize() {
        outputLabel.setText("");
        executeBtn.setOnAction(e -> {
            outputLabel.setText(Lab6Handler.start());
        });
        homeBtn.setOnMouseClicked(SwitcherController::switchToHome);
    }

}
