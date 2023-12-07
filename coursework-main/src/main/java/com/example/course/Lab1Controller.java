package com.example.course;

import java.util.ArrayList;
import java.util.List;

import com.example.course.lab1.Lab1Handler;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Lab1Controller {
    private static final List<String> METHOD_VARIANTS = new ArrayList<>();

    static {
        METHOD_VARIANTS.add("walk");
        METHOD_VARIANTS.add("ride");
        METHOD_VARIANTS.add("fly");
    }

    @FXML
    private Button executeBtn;

    @FXML
    private ImageView homeBtn;

    @FXML
    private ChoiceBox<String> moveSelection;

    @FXML
    private TextField nameField;

    @FXML
    private Text outputText;

    @FXML
    public void initialize() {
        moveSelection.getItems().addAll(METHOD_VARIANTS);
        moveSelection.setValue(METHOD_VARIANTS.get(0));

        executeBtn.setOnAction(e -> {
            String name = nameField.getText();
            if (name.isEmpty()) {
                outputText.setText("You didn't provide a name.");
            } else {
                String move = moveSelection.getValue();
                outputText.setText(Lab1Handler.start(name, move));
            }
        });
        homeBtn.setOnMouseClicked(SwitcherController::switchToHome);
    }
}
