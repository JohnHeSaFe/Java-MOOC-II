import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;

    public VehicleRegistry() {
        registry = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (registry.containsKey(licensePlate)) {
            return false;
        }

        registry.put(licensePlate, owner);
        return true;
    }

    public String get(LicensePlate licensePlate) {
        return registry.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (!registry.containsKey(licensePlate)) {
            return false;
        }

        registry.remove(licensePlate);
        return true;
    }

    public void printLicensePlates() {
        System.out.println("License plates:");
        for (LicensePlate licensePlate : this.registry.keySet()) {
            System.out.println("- " + licensePlate);
        }
    }

    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();

        System.out.println("Owners:");
        for (String owner : this.registry.values()) {
            if (!owners.contains(owner)) {
                System.out.println("- " + owner);
                owners.add(owner);
            }
        }
    }
}
