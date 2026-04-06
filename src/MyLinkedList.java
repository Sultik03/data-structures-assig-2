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
    public void add(T element) { //add element to end
        MyNode newNode = new MyNode(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T element) { //add at index
        if (index == size) {
            add(element);
            return;
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; //walks forward from head until current points to the node sitting at index
        }
        MyNode newNode = new MyNode(element);
        newNode.next = current; //new node points forward to current
        newNode.prev = current.prev; //new node points back to current's prev

        if (current != null) {
            current.prev.next = newNode; //assigning newNode
        } else {
            head = newNode;
        }
        current.prev = newNode;
        size++;
    }

    @Override
    public T get(int index) {
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; //walks forward from head until current points to the node sitting at index
        }
        return current.data; //returns the element at index
    }

    @Override
    public void remove(int index) {
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.prev != null) {
            current.prev.next = current.next; //removes element at index by replacing current.pre.next with current.next
        } else {
            head = current.next;
        }
    }

    @Override
    public void set(int index, T item) {
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = item; //replace element at index
    }


    @Override
    public void addFirst(T item) {
        
    }

    @Override
    public void addLast(T item) { //add element at beginning
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {

        }

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
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
