import java.util.Iterator;
//this is a doubly linked list btw

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
    public void addFirst(T item) { //add element at beginning
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) { //add element at enf
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T getFirst() {
        return head.data; //returns the first element
    }

    @Override
    public T getLast() {
        return tail.data; //returns the last element
    }

    @Override
    public void removeFirst() { //remove first element
        if (head == null) {
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) {
            return;
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
    }

    @Override
    public void sort() { //bubble sort
        if (size < 2) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            MyNode current = head;
            for (int j = 0; j < size - i - 1; j++) {
                Comparable a = (Comparable) current.data;
                Comparable b = (Comparable) current.next.data;
                if (a.compareTo(b) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) { //first occurence
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() { //converts to array
        Object[] arr = new Object[size];
        MyNode current = head;
        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }

    @Override
    public void clear() { //clear list
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() { //returns the size
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
