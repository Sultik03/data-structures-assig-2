import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode { //node class
        T data;
        MyNode next;
        MyNode prev;
        MyNode(T data) {
            this.data = data;
        }
    }
    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void add(T item) {

    }

    @Override
    public void set(int index, T item) {

    }

    @Override
    public void add(int index, T item) {

    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
