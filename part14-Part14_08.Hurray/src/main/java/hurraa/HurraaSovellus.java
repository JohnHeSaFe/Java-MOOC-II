package hurraa;


// import javafx.scene.media.AudioClip;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        Button nappi = new Button("Hurraa!");
        pane.setCenter(nappi);

        /*
        AudioClip sound = new AudioClip(getClass().getResource("/Applause-Yannick_Lemieux.wav").toExternalForm());

        nappi.setOnAction((event) -> {
            sound.play();
        });
         */
        

        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
