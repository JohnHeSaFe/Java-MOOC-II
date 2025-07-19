public class Hideout<T> {
    private T t;

    public Hideout() {

    }

    public void putIntoHideout(T toHide) {
        t = toHide;
    }

    public T takeFromHideout() {
        T tempT = t;
        t = null;
        return tempT;
    }

    public boolean isInHideout() {
        return t != null;
    }
}
