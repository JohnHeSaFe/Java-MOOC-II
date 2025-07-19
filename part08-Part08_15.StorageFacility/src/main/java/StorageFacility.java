import java.util.HashMap;
import java.util.ArrayList;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> units;

    public StorageFacility() {
        units = new HashMap<>();
    }

    public void add(String unit, String item) {
        if (units.get(unit) == null) {
            units.put(unit, new ArrayList<String>());
        }
        units.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        if (units.get(storageUnit) == null) {
            return new ArrayList<String>();
        }
        return units.get(storageUnit);
    }

    public void remove(String storageUnit, String itemToRemove) {
        ArrayList<String> contents = this.contents(storageUnit);
        if (contents.isEmpty()) {
            return;
        }
        for (String item : contents) {
            if (item.equals(itemToRemove)) {
                contents.remove(item);
                break;
            }
        }
        if (contents.isEmpty()) {
            units.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        return new ArrayList<>(units.keySet());
    }
}
