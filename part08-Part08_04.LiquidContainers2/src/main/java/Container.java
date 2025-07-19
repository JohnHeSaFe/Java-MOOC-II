public class Container {
    private int amountOfLiquid;

    public Container() {
        amountOfLiquid = 0;
    }

    public void add(int amount) {
        if (amount < 0) {
            return;
        }

        amountOfLiquid += amount;
        
        if (amountOfLiquid > 100) {
            amountOfLiquid = 100;
        }
    }

    public void remove(int amount) {
        if (amount < 0) {
            return;
        }
        
        amountOfLiquid -= amount;
        
        if (amountOfLiquid < 0) {
            amountOfLiquid = 0;
        }
    }

    public int contains() {
        return amountOfLiquid;
    }

    @Override
    public String toString() {
        return amountOfLiquid + "/100";
    }
}
