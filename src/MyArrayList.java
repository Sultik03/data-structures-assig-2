public class MyArrayList<T> implements MyList<T> {
    private Object[] data; //array to store elements
    private int size; //current size of elements
    private int init_capacity = 10;
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
}
