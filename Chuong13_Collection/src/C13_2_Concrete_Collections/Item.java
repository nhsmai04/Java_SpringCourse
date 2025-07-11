package C13_2_Concrete_Collections;

public class Item implements Comparable<Item> {
	private int id;
    private String description;

    public Item(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }

    @Override
    public int compareTo(Item other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Item{id=" + id + ", description='" + description + "'}";
    }
}
