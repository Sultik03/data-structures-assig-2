import java.util.Iterator;

/**
 * A dynamic array-based implementation of the MyList interface.
 * Automatically resizes when capacity is exceeded.
 * @param <T> the type of elements stored in this list
 */
public class MyArrayList<T extends Comparable<T>> implements MyList<T> {

    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /** Creates an empty MyArrayList with default initial capacity. */
    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /** Ensures the internal array has enough room for at least one more element. */
    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < size; i++) newData[i] = data[i];
            data = newData;
        }
    }

    /** Validates that the given index is within [0, size). */
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * Appends the specified item to the end of the list.
     * @param item element to add
     */
    @Override
    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    /**
     * Replaces the element at the specified index.
     * @param index position to update
     * @param item  new value
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        data[index] = item;
    }

    /**
     * Inserts an element at the specified index, shifting subsequent elements right.
     * @param index position to insert at
     * @param item  element to insert
     */
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        ensureCapacity();
        for (int i = size; i > index; i--) data[i] = data[i - 1];
        data[index] = item;
        size++;
    }

    /** Inserts an element at the beginning of the list. */
    @Override
    public void addFirst(T item) { add(0, item); }

    /** Appends an element to the end of the list. */
    @Override
    public void addLast(T item) { add(item); }

    /**
     * Returns the element at the specified index.
     * @param index position to retrieve
     * @return element at index
     */
    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    /** Returns the first element. */
    @Override
    public T getFirst() { return get(0); }

    /** Returns the last element. */
    @Override
    public T getLast() { return get(size - 1); }

    /**
     * Removes the element at the specified index, shifting subsequent elements left.
     * @param index position to remove
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
        data[--size] = null;
    }

    /** Removes the first element. */
    @Override
    public void removeFirst() { remove(0); }

    /** Removes the last element. */
    @Override
    public void removeLast() { remove(size - 1); }

    /**
     * Sorts the list in ascending order using insertion sort.
     * Elements must implement Comparable.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void sort() {
        for (int i = 1; i < size; i++) {
            T key = (T) data[i];
            int j = i - 1;
            while (j >= 0 && ((T) data[j]).compareTo(key) > 0) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    /**
     * Returns the index of the first occurrence of the specified object.
     * @param object element to search for
     * @return index, or -1 if not found
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(object)) return i;
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified object.
     * @param object element to search for
     * @return index, or -1 if not found
     */
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--)
            if (data[i].equals(object)) return i;
        return -1;
    }

    /**
     * Returns true if the list contains the specified object.
     * @param object element to check
     */
    @Override
    public boolean exists(Object object) { return indexOf(object) != -1; }

    /** Returns a copy of the internal array containing only the list elements. */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) result[i] = data[i];
        return result;
    }

    /** Removes all elements from the list. */
    @Override
    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /** Returns the number of elements in the list. */
    @Override
    public int size() { return size; }

    /** Returns an iterator over the elements in this list. */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;
            public boolean hasNext() { return cursor < size; }
            @SuppressWarnings("unchecked")
            public T next() { return (T) data[cursor++]; }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}