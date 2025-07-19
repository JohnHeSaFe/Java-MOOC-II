import java.util.ArrayList;

public class BoxWithMaxWeight extends Box{
    private ArrayList<Item> items;
    private int capacity;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (item.getWeight() <= capacity) {
            items.add(item);
            capacity -= item.getWeight();
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}
