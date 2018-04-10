import java.util.ArrayList;

public class Library<T> {
    ArrayList<T> items;

    public Library() {
        this.items = new ArrayList<T>();
    }

    public void addItem(T item) {
        this.items.add(item);
    }

    public int itemCount() {
        return this.items.size();
    }
}
