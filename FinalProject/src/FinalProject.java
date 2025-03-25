import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinalProject extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Conference Registration Options");

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));

        // Registration Type Radio Buttons
        ToggleGroup registrationGroup = new ToggleGroup();
        RadioButton generalRadio = new RadioButton("General Registration ($895)");
        RadioButton studentRadio = new RadioButton("Student Registration ($495)");
        generalRadio.setToggleGroup(registrationGroup);
        studentRadio.setToggleGroup(registrationGroup);

        HBox registrationBox = new HBox(10, generalRadio, studentRadio);
        mainLayout.getChildren().add(registrationBox);

        // Optional Dinner CheckBox
        CheckBox dinnerCheckbox = new CheckBox("Opening Night Dinner ($30)");
        dinnerCheckbox.setDisable(true);
        mainLayout.getChildren().add(dinnerCheckbox);

        // Workshops CheckBoxes
        Label workshopLabel = new Label("Optional Preconference Workshops:");
        mainLayout.getChildren().add(workshopLabel);

        CheckBox workshop1 = new CheckBox("Introduction to E-commerce ($295)");
        CheckBox workshop2 = new CheckBox("The Future of the Web ($295)");
        CheckBox workshop3 = new CheckBox("Advanced Visual Basic ($395)");
        CheckBox workshop4 = new CheckBox("Network Security ($395)");

        VBox workshopsBox = new VBox(5, workshop1, workshop2, workshop3, workshop4);
        workshopsBox.setPadding(new Insets(5));
        mainLayout.getChildren().add(workshopsBox);

        // Disable workshops and dinner initially
        workshop1.setDisable(true);
        workshop2.setDisable(true);
        workshop3.setDisable(true);
        workshop4.setDisable(true);

        // Enable optional features when registration is selected
        registrationGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            boolean registrationSelected = (newValue != null);
            dinnerCheckbox.setDisable(!registrationSelected);
            workshop1.setDisable(!registrationSelected);
            workshop2.setDisable(!registrationSelected);
            workshop3.setDisable(!registrationSelected);
            workshop4.setDisable(!registrationSelected);
        });

        // Close Button
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {
            int total = calculateTotal(generalRadio, studentRadio, dinnerCheckbox, workshop1, workshop2, workshop3, workshop4);
            primaryStage.close();

            // Display total in new window
            Stage totalStage = new Stage();
            VBox totalLayout = new VBox(10);
            totalLayout.setPadding(new Insets(10));
            totalLayout.getChildren().add(new Label("Total Registration Fee: $" + total));
            Scene totalScene = new Scene(totalLayout, 300, 200);
            totalStage.setScene(totalScene);
            totalStage.setTitle("Registration Total");
            totalStage.show();
        });

        mainLayout.getChildren().add(closeButton);

        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private int calculateTotal(RadioButton general, RadioButton student, CheckBox dinner,
                               CheckBox w1, CheckBox w2, CheckBox w3, CheckBox w4) {
        int total = 0;

        if (general.isSelected()) {
            total += 895;
        } else if (student.isSelected()) {
            total += 495;
        }

        if (dinner.isSelected()) {
            total += 30;
        }

        if (w1.isSelected()) total += 295;
        if (w2.isSelected()) total += 295;
        if (w3.isSelected()) total += 395;
        if (w4.isSelected()) total += 395;

        return total;
    }

    public static void main(String[] args) {
        launch(args);
    }
}