package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea textArea = new TextArea();

        HBox groupButtons = new HBox();
        groupButtons.setSpacing(10);
        Label lettersLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestWordLabel = new Label("The longest word is: ");
        groupButtons.getChildren().add(lettersLabel);
        groupButtons.getChildren().add(wordsLabel);
        groupButtons.getChildren().add(longestWordLabel);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(textArea);
        borderPane.setBottom(groupButtons);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.show();

        textArea. textProperty().addListener((change, oldValue, newValue) -> {
            int numLetters = newValue.length();

            String [] words = newValue.split(" ");
            int numWords = words.length;

            String longestWord = "";
            for (String word: words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }

            lettersLabel.setText("Letters: " + numLetters);
            wordsLabel.setText("Words: " + numWords);
            longestWordLabel.setText("The longest word is: " + longestWord);
        });
    }

}
