package asteroids;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public abstract class Character {

    private Polygon character;
    private Point2D movement;
    private boolean isAlive;

    public Character(Polygon polygon, int x, int y, Color fill, Color edge) {
        this.character = polygon;
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);
        this.character.setFill(fill);
        this.character.setStroke(edge);
        this.character.setStrokeWidth(1);
        this.movement = new Point2D(0, 0);
        this.isAlive = true;
    }

    public Polygon getCharacter() {
        return character;
    }

    public void setCharacter(Polygon character) {
        this.character = character;
    }

    public Point2D getMovement() {
        return movement;
    }

    public void setMovement(Point2D movement) {
        this.movement = movement;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void turnLeft() {
        this.character.setRotate(this.character.getRotate() - 2);
    }

    public void turnRight() {
        this.character.setRotate(this.character.getRotate() + 2);
    }

    public void move() {
        this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
        this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());

        if (this.character.getTranslateX() < 0) {
            this.character.setTranslateX(this.character.getTranslateX() + AsteroidsApplication.WIDTH);
        }

        if (this.character.getTranslateX() > AsteroidsApplication.WIDTH) {
            this.character.setTranslateX(this.character.getTranslateX() % AsteroidsApplication.WIDTH);
        }

        if (this.character.getTranslateY() < 0) {
            this.character.setTranslateY(this.character.getTranslateY() + AsteroidsApplication.HEIGHT);
        }

        if (this.character.getTranslateY() > AsteroidsApplication.HEIGHT) {
            this.character.setTranslateY(this.character.getTranslateY() % AsteroidsApplication.HEIGHT);
        }
    }

    public void accelerate(double factor) {
        double changeX = Math.cos(Math.toRadians(this.character.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.character.getRotate()));

        changeX *= factor;
        changeY *= factor;

        this.movement = this.movement.add(changeX, changeY);
    }

    public boolean collide(Character other) {
        Shape collisionArea = Shape.intersect(this.character, other.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }
}
