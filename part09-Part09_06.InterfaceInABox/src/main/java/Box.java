import java.util.ArrayList;

public class Box implements Packable{
    private ArrayList<Packable> items;
    private double capacity;

    public Box(double maxCapacity) {
        this.capacity = maxCapacity;
        items = new ArrayList<>();
    }

    public void add(Packable item) {
        if (item.weight() <= capacity) {
            items.add(item);
            capacity -= item.weight();
        }
    }

    @Override
    public double weight() {
        double weight = 0;
        for (Packable item : items) {
            weight += item.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }
}
