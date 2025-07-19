package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();

        int nCopies = 0;
        while (nCopies < 4) {
            int xCoordinate = -1;
            int yCoordinate = -1;
            switch (nCopies) {
                case 0:
                    xCoordinate = 0;
                    yCoordinate = 0;
                    break;
                case 1:
                    xCoordinate = width / 2;
                    yCoordinate = 0;
                    break;
                case 2:
                    xCoordinate = 0;
                    yCoordinate = height / 2;
                    break;
                case 3:
                    xCoordinate = width / 2;
                    yCoordinate = height / 2;
                    break;
            }

            int yIndex = 0;
            while (yIndex < height / 2) {
                int xIndex = 0;
                while (xIndex < width / 2) {
                    Color color = imageReader.getColor(xIndex * 2, yIndex * 2);
                    double red = 1.0 - color.getRed();
                    double green = 1.0 - color.getGreen();
                    double blue = 1.0 - color.getBlue();
                    double opacity = color.getOpacity();

                    Color newColor = new Color(red, green, blue, opacity);

                    imageWriter.setColor(xCoordinate + xIndex, yCoordinate + yIndex, newColor);

                    xIndex++;
                }
                yIndex++;
            }

            nCopies++;
        }
            

        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
