package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {


    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField field = new TextField();
        Button button = new Button("Update");
        Label label = new Label();

        VBox layout = new VBox();
        layout.getChildren().add(field);
        layout.getChildren().add(button);
        layout.getChildren().add(label);

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();

        button.setOnAction((event) -> {
            label.setText(field.getText());
        });
    }

}
