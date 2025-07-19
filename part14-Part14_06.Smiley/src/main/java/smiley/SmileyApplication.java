package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SmileyApplication extends Application {


    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        int scale = 100;
        Canvas canvas = new Canvas(8 * scale, 8 * scale);
        GraphicsContext painter = canvas.getGraphicsContext2D();

        painter.fillRect(2 * scale, 1 * scale, 1 * scale, 1 * scale);
        painter.fillRect(5 * scale, 1 * scale, 1 * scale, 1 * scale);
        painter.fillRect(1 * scale, 4 * scale, 1 * scale, 1 * scale);
        painter.fillRect(6 * scale, 4 * scale, 1 * scale, 1 * scale);
        painter.fillRect(2 * scale, 5 * scale, 4 * scale, 1 * scale);

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(canvas);

        primaryStage.setScene(new Scene(paintingLayout));
        primaryStage.show();
    }

}
