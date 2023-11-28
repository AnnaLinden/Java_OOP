package task2;

import java.util.ArrayList;

public class SafeArrayList<T> {
    private final ArrayList<T> list = new ArrayList<>();

    public synchronized void add(T item) {
        list.add(item);
    }

    public synchronized T remove(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + list.size());
        }
        return list.remove(index);
    }

    public synchronized int size() {
        return list.size();
    }
}
