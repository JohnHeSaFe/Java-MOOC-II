import java.util.ArrayList;

public class Herd implements Movable {
    private ArrayList<Movable> herd;

    public Herd() {
        herd = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        herd.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable mob : herd) {
            mob.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (Movable mob : herd) {
            output += mob + "\n";
        }
        return output;
    }
}
