package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {
    @Override
    public void start(Stage window) {
        Label textComponent = new Label("Text element");
        Button buttonComponent = new Button("This is a button");
        
        VBox componentGroup = new VBox(); 
        componentGroup.getChildren().add(textComponent);
        componentGroup.getChildren().add(buttonComponent);
        
        Scene view = new Scene(componentGroup);

        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
