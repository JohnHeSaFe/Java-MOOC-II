import java.util.ArrayList;

public class MisplacingBox extends Box{
    private ArrayList<Item> items;

    @Override
    public void add(Item item) {
        items = new ArrayList<>();
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
    
}
