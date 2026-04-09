public class MyStack<T> {
    private MyArrayList<T> list = new MyArrayList<>();
    public void push (T element) { //adds the element at the top of the stack
        list.add(element);
    }
    public int size () { //returns the size of the stack
        return list.size();
    }
    public T pop () { // deletes the topmost element of the stack
        T removingItem = peek();
        list.removeLast();
        return removingItem;
    }
    public T peek () { //returns a reference to the topmost element of the stack
        return list.get(list.size() - 1);
    }
    public boolean isEmpty () { //returns whether stack is empty
        return list.isEmpty();
    }
}
