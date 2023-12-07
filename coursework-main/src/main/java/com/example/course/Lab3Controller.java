package com.example.course;

import java.util.*;

import com.example.course.lab3.Lab3Handler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class Lab3Controller {
    private static final Map<Integer, String> VARIANT_DATA_INFO = new HashMap<>();

    static {
        VARIANT_DATA_INFO.put(1, getFirstVariantDataInfo());
        VARIANT_DATA_INFO.put(2, getSecondVariantDataInfo());
        VARIANT_DATA_INFO.put(3, getThirdVariantDataInfo());
    }

    @FXML
    private TextArea  dataLabel;

    @FXML
    private Button executeBtn;

    @FXML
    private TextArea outputLabel;

    @FXML
    private ChoiceBox<String> variantSelection;

    private static final List<String> VARIANTS = new ArrayList<>();

    static {
        VARIANTS.add("variant № 1");
        VARIANTS.add("variant № 2");
        VARIANTS.add("variant № 3");
    }

    @FXML
    private ImageView homeBtn;

    @FXML
    public void initialize() {
        variantSelection.getItems().addAll(VARIANTS);
        variantSelection.setValue(VARIANTS.get(0));
        dataLabel.setText(getFirstVariantDataInfo());
        variantSelection.setOnAction(e -> {
            dataLabel.setText(VARIANT_DATA_INFO.getOrDefault(getVariant(variantSelection.getValue()), "Something went wrong"));
        });
        outputLabel.setText("");
        executeBtn.setOnAction(e -> {
            outputLabel.setText(Lab3Handler.start(getVariant(variantSelection.getValue())));
        });
        homeBtn.setOnMouseClicked(SwitcherController::switchToHome);
    }

    private int getVariant(String variantString) {
        String variantNumber = variantString.split(" ")[2];
        return Integer.parseInt(variantNumber);
    }


    private static String getFirstVariantDataInfo() {
        return "LynxKerr - 1, OtocolobusManul - 1, ErinaceusEuropaeus - 1\nFunction is segregate(Mammalia, Erinaceidae, Felidae, Carnivora)";
    }

    private static String getSecondVariantDataInfo() {
        return "LynxKerr - 2, OtocolobusManul - 2, ErinaceusEuropaeus - 0\nFunction is segregate(Carnivora, Chordata, OtocolobusManul, Felidae)";
    }

    private static String getThirdVariantDataInfo() {
        return "LynxKerr - 0, OtocolobusManul - 0, ErinaceusEuropaeus - 3\nFunction is segregate(Erinaceidae, Eupotyphla, Carnivora, Carnivora)";
    }
}
