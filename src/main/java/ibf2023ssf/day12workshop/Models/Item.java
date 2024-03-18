package ibf2023ssf.day12workshop.Models;

public class Item {
    private String name;
    private int quantity;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //name|quantity (deserialise each cart item)
    public static Item toItem(String str) {
        String[] fields = str.split("\\|");
        Item item = new Item();
        item.setName(fields[0]);
        item.setQuantity(Integer.parseInt(fields[1]));
        return item;
    }

    //serialise the each item
    public String toItemString () {
        return "%s|%d".formatted(name,quantity);
    }

}
