import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] data; //array to store elements
    private int size; //current size of elements
    private int init_capacity = 10; //initializing default capacity
    public MyArrayList () {
        data = new Object[init_capacity]; //initial capacity
        size = 0;
    }
    private void resize () {
        Object[] newData = new Object[data.length * 2]; //resize the capacity twice when it's full
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    @Override
    public void add(T element) {
        if (size == data.length) {
            resize();
        }
        data[size++] = element; //adds new element to the end
    }
    @Override
    public void add(int index, T element) {
        if (size == data.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element; //adds a new element at a specific index
        size++;
    }
    @Override
    public T get(int index) {
        return (T) data[index]; //returns the element at index casting it down to T
    }
    @Override
    public void remove(int index) {
        T removed = (T) data[index];
        for (int i = index; i < size - 1; i++) { //remove element by index
            data[i] = data[i + 1];
        }
        size--;
        System.out.println(removed);
    }

    @Override
    public void removeFirst() { // removes the first element
        if (isEmpty()) {
            return;
        }
        remove(0);
    }

    @Override
    public void removeLast() { //removes the last element
        if (isEmpty()) {
            return;
        }
        remove(size - 1);
    }

    @Override
    public void sort() { //simple bubble sort
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable a = (Comparable) data[j];
                Comparable b = (Comparable) data[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) { //find first occurence
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) { //find last occurence
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) { //check if elements exists
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() { // convert to array
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = data[i];
        }
        return arr;
    }

    @Override
    public void clear() { //clear list
        data = new Object[init_capacity];
        size = 0;
    }
    @Override
    public void set(int index, T item) {
        data[index] = item; //replace element at index
    }
    @Override
    public void addFirst(T item) {
        add(0, item); //add element at beginning;
    }
    @Override
    public void addLast(T item) {
        add(item); //add element at end
    }
    @Override
    public T getFirst() {
        return (T) data[0]; //get first elements
    }
    @Override
    public T getLast() {
        return (T) data[size - 1]; // get last element
    }
    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int current = 0;
            @Override
            public boolean hasNext() {
                return current < size;
            }
            @Override
            public T next() {
                return (T) data[current++];
            }
        };
    }
}
