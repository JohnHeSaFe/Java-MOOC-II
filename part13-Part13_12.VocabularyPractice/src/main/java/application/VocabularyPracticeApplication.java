package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {
    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Dictionary dictionary = new Dictionary();
        Button inputButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");
        HBox menu = new HBox();
        menu.getChildren().addAll(inputButton, practiceButton);
        menu.setSpacing(10);
        menu.setPadding(new Insets(20, 20, 20, 20));

        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);

        BorderPane layout = new BorderPane();
        layout.setTop(menu);
        layout.setCenter(inputView.getView());

        inputButton.setOnMouseClicked((event) -> layout.setCenter(inputView.getView()));
        practiceButton.setOnMouseClicked((event) -> layout.setCenter(practiceView.getView()));

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }
}
