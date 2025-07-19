package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application {


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label instructionText = new Label("Enter your name and start.");
        TextField nameField = new TextField();
        Button startButton = new Button("Start");

        VBox enterNameLayout = new VBox();

        enterNameLayout.getChildren().add(instructionText);
        enterNameLayout.getChildren().add(nameField);
        enterNameLayout.getChildren().add(startButton);

        enterNameLayout.setPrefSize(500, 300);
        enterNameLayout.setAlignment(Pos.CENTER);
        enterNameLayout.setPadding(new Insets(50, 50, 50, 50));

        Scene enterNameView = new Scene(enterNameLayout);


        Label welcomeText = new Label();

        FlowPane welcomeLayout = new FlowPane();

        welcomeLayout.getChildren().add(welcomeText);

        welcomeLayout.setPrefSize(500, 300);
        welcomeLayout.setAlignment(Pos.CENTER);

        Scene welcomeView = new Scene(welcomeLayout);

        startButton.setOnAction((event) -> {
            welcomeText.setText("Welcome " + nameField.getText() + "!");
            primaryStage.setScene(welcomeView);
        });

        primaryStage.setScene(enterNameView);
        primaryStage.show();
    }
}
