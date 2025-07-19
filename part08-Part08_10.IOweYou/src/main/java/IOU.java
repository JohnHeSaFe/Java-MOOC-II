import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> debtMap;

    public IOU() {
        this.debtMap = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        this.debtMap.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        return this.debtMap.getOrDefault(toWhom, 0.0);
    }
}
