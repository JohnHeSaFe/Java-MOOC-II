package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

   @Override
    public void start(Stage window) throws Exception {
        BorderPane firstLayout = new BorderPane();
        Label firstLabel = new Label("First view!");
        Button toSecond = new Button("To the second view!");
        firstLayout.setTop(firstLabel);
        firstLayout.setCenter(toSecond);
        Scene firstScene = new Scene(firstLayout);

        VBox secondLayout = new VBox();
        Button toThird = new Button("To the third view!");
        Label secondLabel = new Label("Second view!");
        secondLayout.getChildren().addAll(toThird, secondLabel);
        Scene secondScene = new Scene(secondLayout);

        GridPane thirdLayout = new GridPane();
        Label thirdLabel = new Label("Third view!");
        Button toFirst = new Button("To the first view!");
        thirdLayout.add(thirdLabel, 0, 0);
        thirdLayout.add(toFirst, 1, 1);
        Scene thirdScene = new Scene(thirdLayout);

        toSecond.setOnAction(e -> window.setScene(secondScene));
        toThird.setOnAction(e -> window.setScene(thirdScene));
        toFirst.setOnAction(e -> window.setScene(firstScene));

        window.setScene(firstScene);
        window.show();
    }
}
