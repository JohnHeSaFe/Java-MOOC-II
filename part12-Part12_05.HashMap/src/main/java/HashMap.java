import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> {
    private ArrayList<ArrayList<Pair<K, V>>> values;
    private int firstFreeIndex;

    public HashMap() {
        this.values = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            values.add(null);
        }
        this.firstFreeIndex = 0;
    }

    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % values.size());
        if (this.values.get(hashValue) == null) {
            return null;
        }

        List<Pair<K, V>> valuesAtIndex = (List<Pair<K, V>>) this.values.get(hashValue);

        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (valuesAtIndex.get(i).getKey().equals(key)) {
                return valuesAtIndex.get(i).getValue();
            }
        }

        return null;
    }

    public void add(K key, V value) {
        if ((1.0 * firstFreeIndex / values.size()) > 0.75) {
            grow();
        }
        
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);

        int index = getIndexOfKey((ArrayList<Pair<K, V>>) valuesAtIndex, key);

        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this.firstFreeIndex++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }
    }

    private List<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.size());
        if (values.get(hashValue) == null) {
            values.set(hashValue, new ArrayList<>());
        }

        return values.get(hashValue);
    }

    private int getIndexOfKey(ArrayList<Pair<K, V>> list, K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        ArrayList<ArrayList<Pair<K, V>>> newValues = new ArrayList<>();
        for (int i = 0; i < values.size() * 2; i++) {
            newValues.add(null);
        }

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) != null) {
                copy(newValues, i);
            }
        }

        this.values = newValues;
    }

    private void copy(ArrayList<ArrayList<Pair<K, V>>> newArray, int fromIdx) {
        ArrayList<Pair<K, V>> oldList = values.get(fromIdx);

        for (int i = 0; i < oldList.size(); i++) {
            Pair<K, V> pair = oldList.get(i);
            int hash = Math.abs(pair.getKey().hashCode() % newArray.size());

            if (newArray.get(hash) == null) {
                newArray.set(hash, new ArrayList<>());
            }

            newArray.get(hash).add(pair);
        }
    }
}
