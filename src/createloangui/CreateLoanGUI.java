/**
 * Name: Yara Most
 * Class: Object Oriented Programming 
 * Date: 04/02/2023
 * Homework 10 - Java GUI
 * Description: this program uses JavaFX to have the user input loan information
 *              then creates an arrayList with all the loans entered and display them
 *              in a new window.
 */
package createloangui;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CreateLoanGUI extends Application {

    // global variables 
    ArrayList<Loan> list = new ArrayList<>();
    TextArea taDisplay = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        // Textfields, buttons, and Radio buttons
        TextField tfPrimeRate = new TextField();
        TextField tfLoanNum = new TextField();
        TextField tfName = new TextField();
        TextField tfLoanAmnt = new TextField();
        TextField tfLoanTerm = new TextField();

        final ToggleGroup group = new ToggleGroup();
        RadioButton rbPersonalLoan = new RadioButton("Personal");
        RadioButton rbBusinessLoan = new RadioButton("Business");
        rbPersonalLoan.setToggleGroup(group);
        rbBusinessLoan.setToggleGroup(group);

        Button btnAdd = new Button("Add");
        Button btnDisplay = new Button("Display");

        // when "Add" is clicked
        btnAdd.setOnAction(e -> {
            if (rbPersonalLoan.isSelected()) {
                list.add(new PersonalLoan(Integer.valueOf(tfLoanNum.getText()), tfName.getText(),
                        Double.valueOf(tfLoanAmnt.getText()), Integer.valueOf(tfLoanTerm.getText()),
                        Double.valueOf(tfPrimeRate.getText())));
            } else if (rbBusinessLoan.isSelected()) {
                list.add(new BusinessLoan(Integer.valueOf(tfLoanNum.getText()), tfName.getText(),
                        Double.valueOf(tfLoanAmnt.getText()), Integer.valueOf(tfLoanTerm.getText()),
                        Double.valueOf(tfPrimeRate.getText())));
            }
            tfPrimeRate.clear();
            tfLoanNum.clear();
            tfName.clear();
            tfLoanAmnt.clear();
            tfLoanTerm.clear();
            rbPersonalLoan.setSelected(false);
            rbBusinessLoan.setSelected(false);
        });

        // when "Display" is clicked
        btnDisplay.setOnAction(e1 -> {
            display();
        });

        // controls layout and alignment
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Prime Interest Rate"), 0, 0);
        gridPane.add(new Label("Loan Type"), 0, 1);
        gridPane.add(new Label("Loan Number"), 0, 2);
        gridPane.add(new Label("Last Name"), 0, 3);
        gridPane.add(new Label("Loan Amount"), 0, 4);
        gridPane.add(new Label("Loan Term"), 0, 5);
        gridPane.add(tfPrimeRate, 1, 0);
        gridPane.add(rbPersonalLoan, 1, 1);
        gridPane.add(rbBusinessLoan, 2, 1);
        gridPane.add(tfLoanNum, 1, 2);
        gridPane.add(tfName, 1, 3);
        gridPane.add(tfLoanAmnt, 1, 4);
        gridPane.add(tfLoanTerm, 1, 5);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 15, 15, 30));

        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnAdd, btnDisplay);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(30);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(gridPane);
        borderPane.setCenter(hbox);
        Scene scene = new Scene(borderPane, 450, 300);

        primaryStage.setTitle("Loan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // method to display the loans entered
    // it displays the info in a text area in a new window
    // can be closed and displayed again
    public void display() {
        taDisplay.clear();
        taDisplay.setEditable(false);
        
        for (Loan o : list) {
            taDisplay.appendText(o.toString());
            taDisplay.appendText("\nTotal owed at due date: $" + o.calcTotal() + "\n\n");
        }
        
        Button btnClose = new Button("Close");
        
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(15, 15, 0, 15));
        bPane.setTop(taDisplay);
        bPane.setCenter(btnClose);
        
        Scene scene = new Scene(bPane, 450, 300);

        Stage stageDisplay = new Stage();
        stageDisplay.setTitle("Loan list");
        stageDisplay.setScene(scene);
        stageDisplay.show();
        
        btnClose.setOnAction(e->{
           stageDisplay.close();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
