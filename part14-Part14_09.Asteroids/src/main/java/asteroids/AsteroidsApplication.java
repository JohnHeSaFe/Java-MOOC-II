package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {

    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    private static final long GAME_DURATION = 60_000_000_000L;

    public static void main(String[] args) {
        launch(args);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        
        pane.setBackground(new Background(
            new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)
        ));
        Random rand = new Random();
        int numStars = 60;
        for (int i = 0; i < numStars; i++) {
            double x = rand.nextDouble() * WIDTH;
            double y = rand.nextDouble() * HEIGHT;

            Circle star = new Circle(x, y, 1, Color.WHITE);
            pane.getChildren().add(star);
        }

        AtomicInteger points = new AtomicInteger();
        
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        List<Asteroid> asteroids = new ArrayList<>();
        List<Projectile> projectiles = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            Asteroid asteroid = new Asteroid(rnd.nextInt(WIDTH / 2), rnd.nextInt(HEIGHT));
            asteroids.add(asteroid);
        }

        pane.getChildren().add(ship.getCharacter());
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));

        Scene scene = new Scene(pane);

        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });
        
        Text textPoints = new Text(10, 20, "Points: 0");
        textPoints.setFill(Color.WHITE);
        pane.getChildren().add(textPoints);

        Text textTimeRemaining = new Text(150, 20, "Time remaining: 01:00");
        textTimeRemaining.setFill(Color.WHITE);
        pane.getChildren().add(textTimeRemaining);

        final long startTime = System.nanoTime();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                long elapsedTime = now - startTime;
                long remainingTime = GAME_DURATION - elapsedTime;
                long remainingTimeSeconds = remainingTime / 1_000_000_000L;

                if (remainingTimeSeconds >= 10) {
                    System.out.println("Time remaining: 00:" + remainingTimeSeconds);
                    textTimeRemaining.setText("Time remaining: 00:" + remainingTimeSeconds);
                } else {
                    System.out.println("Time remaining: 00:0" + remainingTimeSeconds);
                    textTimeRemaining.setText("Time remaining: 00:0" + remainingTimeSeconds);
                }
                textTimeRemaining.toFront();

                if(pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                if(pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }

                if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate(0.01);
                }

                if(pressedKeys.getOrDefault(KeyCode.DOWN, false)) {
                    ship.accelerate(-0.01);
                }

                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);

                    projectile.accelerate(0.02);
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    pane.getChildren().add(projectile.getCharacter());
                }

                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());

                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if(projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                        }
                    });

                    if(!projectile.isAlive()) {
                        textPoints.setText("Points: " + points.addAndGet(1000));
                        textPoints.toFront();
                    }
                });

                projectiles.stream()
                    .filter(projectile -> !projectile.isAlive())
                    .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
                projectiles.removeAll(projectiles.stream()
                                        .filter(projectile -> !projectile.isAlive())
                                        .collect(Collectors.toList()));

                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                asteroids.removeAll(asteroids.stream()
                                            .filter(asteroid -> !asteroid.isAlive())
                                            .collect(Collectors.toList()));

                if(Math.random() < 0.01) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if(!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }

                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                        showGameOver(pane);
                    }
                });

                if (elapsedTime >= GAME_DURATION) {
                    stop();
                    showGameOver(pane);
                }
            }
        }.start();

        primaryStage.setTitle("Asteroids!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showGameOver(Pane pane) {
        Text textGameOver = new Text("GAME OVER");
        textGameOver.setStroke(Color.GRAY);
        textGameOver.setFill(Color.WHITE);
        textGameOver.setFont(Font.font("Arial", FontWeight.BOLD, 72));

        textGameOver.setTranslateX(pane.getWidth() / 2 - textGameOver.getLayoutBounds().getWidth() / 2);
        textGameOver.setTranslateY(pane.getHeight() / 2 - textGameOver.getLayoutBounds().getHeight() / 2);

        pane.getChildren().add(textGameOver);
    }
}
