public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        history = new ChangeHistory();
        history.add(initialBalance);
    }

    public String history() {
        return history.toString();
    }

    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        history.add(super.getBalance());
    }

    public double takeFromWarehouse(double amount) {
        double amountRemained = super.takeFromWarehouse(amount);
        history.add(super.getBalance());
        return amountRemained;
    }

    public void printAnalysis() {
        System.out.println("Product: " + super.getName() + "\nHistory: " + history() + 
                            "\nLargest amount of product: " + history.maxValue() + 
                            "\nSmallest amount of product: " + history.minValue() + 
                            "\nAverage: " + history.average());
    }
}
