package icoproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NumberSystemCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create and configure a new grid pane with 20 pixel gap and 15P for padding
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(15, 15, 15, 15));
        //Create the Heading of the calculator
        Label headingLabel = new Label("AL-NUJUUM Number System Calculator");
        grid.add(headingLabel, 0, 0, 2, 1);
        //Create a lebel for input and add it to column 0, row 1
        Label inputLabel = new Label("Input:");
        grid.add(inputLabel, 0, 1);
        //Create a textfield to Input, and add it to column 1, row 1
        TextField inputFild = new TextField();
        grid.add(inputFild, 1, 1);
        // Create a label for the input base and add it to the grid at column 0, row 2
        Label inputBaseLabel = new Label("Input Base:");
        grid.add(inputBaseLabel, 0, 2);
        /*create a combobox for input base show as options, set decimal as default,
         and add it to the grid column 1, row 2*/
        ComboBox<String> inputBaseBox = new ComboBox<>();
        inputBaseBox.getItems().addAll("Binary", "Octal", "Decimal", "Hexadecimal");
        inputBaseBox.setValue("Decimal");
        grid.add(inputBaseBox, 1, 2);
        //Create a lebel for outputbase and add it to column 0, row 3
        Label outputBaseLabel = new Label("Output Base:");
        grid.add(outputBaseLabel, 0, 3);
        /*create a combobox for output base show as options, set decimal as default,
          and add it to the grid column 1, row 3*/
        ComboBox<String> outputBaseBox = new ComboBox<>();
        outputBaseBox.getItems().addAll("Binary", "Octal", "Decimal", "Hexadecimal");
        outputBaseBox.setValue("Decimal");
        grid.add(outputBaseBox, 1, 3);
        // Create a label for the output base and add it to the grid at column 0, row 4
        Label outputLabel = new Label("Output:");
        grid.add(outputLabel, 0, 4);
        //Create a textfield to Input, and add it to column 1, row 4
        TextField outputField = new TextField();
        outputField.setEditable(false);
        grid.add(outputField, 1, 4);
        //Create Convert button that convert one value to another
        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> {
            String input = inputFild.getText();
            String inputBase = inputBaseBox.getValue();
            String outputBase = outputBaseBox.getValue();
            int decimalValue;
            //code for convertion between two numbersystem
            try {
                switch (inputBase) {
                    case "Binary":
                        decimalValue = Integer.parseInt(input, 2);
                        break;
                    case "Octal":
                        decimalValue = Integer.parseInt(input, 8);
                        break;
                    case "Hexadecimal":
                        decimalValue = Integer.parseInt(input, 16);
                        break;
                    default:
                        decimalValue = Integer.parseInt(input);
                }
                String output;
                switch (outputBase) {
                    case "Binary":
                        output = Integer.toBinaryString(decimalValue);
                        break;
                    case "Octal":
                        output = Integer.toOctalString(decimalValue);
                        break;
                    case "Hexadecimal":
                        output = Integer.toHexString(decimalValue).toUpperCase();
                        break;
                    default:
                        output = Integer.toString(decimalValue);
                }
                outputField.setText(output);
            } catch (NumberFormatException ex) {
                outputField.setText("Invalid input");
            }
        });
        /* Create the convert button to the grid at column 1, row 5, create a new scene with 
        the grid, set the scene on the primary stage,set the stage title, and show the stage*/
        grid.add(convertButton, 1, 5);
        Scene sc = new Scene(grid);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Number System Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

