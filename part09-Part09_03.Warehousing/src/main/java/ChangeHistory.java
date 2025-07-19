import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        history.add(status);
    }

    public void clear() {
        history.clear();
    }

    @Override
    public String toString() {
        return history.toString();
    }

    public double maxValue() {
        if (history.isEmpty()) {
            return 0;
        }

        double maxValue = 0.0;
        for (double value : history) {
            if (maxValue < value) {
                maxValue = value;
            }
        }

        return maxValue;
    }

    public double minValue() {
        if (history.isEmpty()) {
            return 0;
        }

        double minValue = history.get(0);
        for (double value : history) {
            if (minValue > value) {
                minValue = value;
            }
        }

        return minValue;
    }

    public double average() {
        if (history.isEmpty()) {
            return 0;
        }

        double total = 0.0;
        for (double value : history) {
            total += value;
        }

        return total / history.size();
    }
}
