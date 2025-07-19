import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> products;
    private Map<String, Integer> stockBalance;

    public Warehouse() {
        products = new HashMap<>();
        stockBalance = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        products.put(product, price);
        stockBalance.put(product, stock);
    }

    public int price(String product) {
        if (products.get(product) == null) {
            return -99;
        }
        return products.get(product);
    }

    public boolean take(String product) {
        if (stockBalance.get(product) != null && stock(product) > 0) {
            stockBalance.put(product, stock(product) - 1);
            return true;
        }
        return false;
    }

    public int stock(String product) {
        if (stockBalance.get(product) == null) {
            return 0;
        }
        return stockBalance.get(product);
    }

    public Set<String> products() {
        return products.keySet();
    }
}
