package genplay;

import java.util.ArrayList;

public class Stack<T> {

    ArrayList<T> array = new ArrayList<>();

    public int getHeight() {
        return array.size();
    }

    public void push(T item) {
        // insert new element at the beginning of the array
        array.add(0, item);
    }

    public T pop() {
        if (array.isEmpty()) {
            return null;
        }
        return array.remove(0);
        // remove the element from the beginning of the array
    }

}
