package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField textField = new TextField("What's your name?");
        Button button = new Button("Submit");

        FlowPane componentGroup = new FlowPane(); 
        componentGroup.getChildren().add(button);
        componentGroup.getChildren().add(textField);
        
        
        Scene view = new Scene(componentGroup);

        primaryStage.setScene(view);
        primaryStage.show();
    }

}
