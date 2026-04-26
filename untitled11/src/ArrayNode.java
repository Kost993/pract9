public class ArrayNode {

    int[] data;
    int size;
    ArrayNode next;
    ArrayNode prev;

    public ArrayNode(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int capacity() {
        return data.length;
    }
}