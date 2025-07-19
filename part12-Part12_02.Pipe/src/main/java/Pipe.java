import java.util.ArrayList;

public class Pipe<T> {
    ArrayList<T> values;

    public Pipe() {
        values = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        values.add(value);
    }

    public T takeFromPipe() {
        if (values.isEmpty()) {
            return null;
        }
        T tempValue = values.get(0);
        values.remove(0);
        return tempValue;
    }

    public boolean isInPipe() {
        return !values.isEmpty();
    }
}
