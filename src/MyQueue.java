public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();
    public T peek() {
        return list.get(0);
    }
    public void enqueue (T element) {
        list.add(element);
    }
    public T dequeue() {
        T removingItem = peek();
        list.removeFirst();
        return removingItem;
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
