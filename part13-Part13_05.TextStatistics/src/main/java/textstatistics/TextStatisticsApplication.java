package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea textArea = new TextArea();

        HBox groupButtons = new HBox();
        groupButtons.setSpacing(10);
        groupButtons.getChildren().add(new Label("Letters: 0"));
        groupButtons.getChildren().add(new Label("Words: 0"));
        groupButtons.getChildren().add(new Label("The longest word is:"));
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(textArea);
        borderPane.setBottom(groupButtons);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.show();
    }

}
