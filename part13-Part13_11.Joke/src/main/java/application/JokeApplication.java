package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JokeApplication extends Application{


    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane layout = new BorderPane();
        layout.setPrefSize(300, 180);
        
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");
        HBox menu = new HBox();
        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        Label text = new Label("What do you call a bear with no teeth?");
        jokeButton.setOnAction((event) -> text.setText("What do you call a bear with no teeth?"));
        answerButton.setOnAction((event) -> text.setText("A gummy bear."));
        explanationButton.setOnAction((event) -> text.setText("That's because a bear with no teeth can't bite and is less scary, just like a gummy bear, soft and harmless."));

        layout.setTop(menu);
        layout.setCenter(text);

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }
}
