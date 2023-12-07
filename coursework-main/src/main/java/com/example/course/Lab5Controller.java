package com.example.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.course.lab5.Lab5Handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class Lab5Controller {
    private static final Map<Integer, String> DEFAULT_DATA_FOR_FUNCTION = new HashMap<>();
    private static final Map<Integer, String> TYPES_FOR_FUNCTION_INPUT = new HashMap<>();
    private static final Map<Integer, String> DESCRIPTION_FOR_FUNCTION = new HashMap<>();

    static {
        DEFAULT_DATA_FOR_FUNCTION.put(1, "1 2 3 4 5");
        DEFAULT_DATA_FOR_FUNCTION.put(2, "Перевод в верхний РЕГИСТР");
        DEFAULT_DATA_FOR_FUNCTION.put(3, "1 1 2 3 2 4 5 6 6");
        DEFAULT_DATA_FOR_FUNCTION.put(4, "aCheck not alist aiwebvn udshv snw");
        DEFAULT_DATA_FOR_FUNCTION.put(5, "1 2 3 4 5 b w");
        DEFAULT_DATA_FOR_FUNCTION.put(6, "1 2 3 4 5");
        DEFAULT_DATA_FOR_FUNCTION.put(7, "cCheck lList Akey -value");

        TYPES_FOR_FUNCTION_INPUT.put(1, "Use only Integer type");
        TYPES_FOR_FUNCTION_INPUT.put(2, "Use only String type");
        TYPES_FOR_FUNCTION_INPUT.put(3, "Use only Numeric type");
        TYPES_FOR_FUNCTION_INPUT.put(4, "Use only String type");
        TYPES_FOR_FUNCTION_INPUT.put(5, "You can use all types");
        TYPES_FOR_FUNCTION_INPUT.put(6, "Use only Integer type");
        TYPES_FOR_FUNCTION_INPUT.put(7, "You can use all types");

        DESCRIPTION_FOR_FUNCTION.put(1, "A method that returns the average value of a list of integers.");
        DESCRIPTION_FOR_FUNCTION.put(2, "A method that converts all strings in a list to uppercase and adding the prefix “_new_” to them.");
        DESCRIPTION_FOR_FUNCTION.put(3, "Method that returns a list of squares of all occurrences only once list elements.");
        DESCRIPTION_FOR_FUNCTION.put(4, "A method that takes a collection of strings as input and returns everything lines starting with a given letter, sorted by alphabet.");
        DESCRIPTION_FOR_FUNCTION.put(5, "A method that takes a collection as input and returns it the last element or throwing an exception if the collection empty.");
        DESCRIPTION_FOR_FUNCTION.put(6, "A method that takes an array of integers as input and returns the sum of even numbers or 0 if there are no even numbers.");
        DESCRIPTION_FOR_FUNCTION.put(7, "Method that converts all strings in a list to a Map, where the first symbol is the key, the remaining ones are the value.");
    }

    @FXML
    private TextArea descriptionField;

    @FXML
    private Button executeBtn;

    @FXML
    private ChoiceBox<String> functionNumber;

    @FXML
    private ImageView homeBtn;

    @FXML
    private Label hintForInput;

    @FXML
    private TextArea inputDataFromUser;

    private static final List<String> VARIANTS = new ArrayList<>();

    static {
        VARIANTS.add("function № 1");
        VARIANTS.add("function № 2");
        VARIANTS.add("function № 3");
        VARIANTS.add("function № 4");
        VARIANTS.add("function № 5");
        VARIANTS.add("function № 6");
        VARIANTS.add("function № 7");
    }

    private static final List<Character> SYMBOLS = new ArrayList<>();

    static {
        for (int symbol = 32; symbol <= 126; symbol++) {
            SYMBOLS.add((char) symbol);
        }
    }

    @FXML
    private TextArea outputLabel;

    @FXML
    private ChoiceBox<Character> selectionSymbol;

    @FXML
    public void initialize() {
        setUpFunctionNumber();
        setUpSelectionSymbol();
        outputLabel.setText("");
        functionNumber.setOnAction(e -> {
            outputLabel.setText("");
            int variantNumber = getVariant(functionNumber.getValue());
            String currentDefaultData = DEFAULT_DATA_FOR_FUNCTION.getOrDefault(variantNumber, "");
            inputDataFromUser.setText(currentDefaultData);
            hintForInput.setText(TYPES_FOR_FUNCTION_INPUT.getOrDefault(variantNumber, ""));
            descriptionField.setText(DESCRIPTION_FOR_FUNCTION.getOrDefault(variantNumber, ""));
        });

        executeBtn.setOnAction(e -> {
            outputLabel.setText("");
            int variantNumber = getVariant(functionNumber.getValue());
            outputLabel.setText(Lab5Handler.start(variantNumber, inputDataFromUser.getText(), selectionSymbol.getValue()));
        });

        homeBtn.setOnMouseClicked(SwitcherController::switchToHome);
    }

    private int getVariant(String variantString) {
        String variantNumber = variantString.split(" ")[2];
        return Integer.parseInt(variantNumber);
    }

    private void setUpFunctionNumber(){
        functionNumber.getItems().addAll(VARIANTS);
        functionNumber.setValue(VARIANTS.get(0));
        inputDataFromUser.setText(DEFAULT_DATA_FOR_FUNCTION.getOrDefault(1, ""));
        hintForInput.setText(TYPES_FOR_FUNCTION_INPUT.getOrDefault(1, "No rules are required"));
        descriptionField.setText(DESCRIPTION_FOR_FUNCTION.getOrDefault(1, ""));
    }

    private void setUpSelectionSymbol() {
        selectionSymbol.getItems().addAll(SYMBOLS);
        selectionSymbol.setValue(SYMBOLS.get(65));
    }
}
