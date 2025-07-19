public class OneItemBox extends Box{
    private Item itemInBox;

    public OneItemBox() {
        itemInBox = null;
    }

    @Override
    public void add(Item item) {
        if (itemInBox == null) {
            itemInBox = item;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return itemInBox != null && itemInBox.equals(item);
    }

}
