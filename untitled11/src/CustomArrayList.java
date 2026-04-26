import java.util.Comparator;

public class CustomArrayList implements Comparable<CustomArrayList> {

    private ArrayNode head;
    private ArrayNode tail;
    private int totalSize;
    private int nodeCapacity;

    public CustomArrayList(int nodeCapacity) {
        this.nodeCapacity = nodeCapacity;
    }

    private ArrayNode createNode() {
        return new ArrayNode(nodeCapacity);
    }

    public void addLast(int value) {

        if (head == null) {
            head = createNode();
            tail = head;
        }

        if (tail.isFull()) {
            ArrayNode newNode = createNode();
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        tail.data[tail.size++] = value;
        totalSize++;
    }

    public int get(int index) {

        if (index < 0 || index >= totalSize)
            throw new IndexOutOfBoundsException();

        ArrayNode current = head;
        int pos = index;

        while (current != null) {
            if (pos < current.size)
                return current.data[pos];

            pos -= current.size;
            current = current.next;
        }

        return -1;
    }

    public void set(int index, int value) {

        if (index < 0 || index >= totalSize)
            throw new IndexOutOfBoundsException();

        ArrayNode current = head;
        int pos = index;

        while (current != null) {
            if (pos < current.size) {
                current.data[pos] = value;
                return;
            }

            pos -= current.size;
            current = current.next;
        }
    }

    public int size() {
        return totalSize;
    }

    public void print() {
        for (int i = 0; i < totalSize; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    // sort by natural order
    public void sort() {
        for (int i = 0; i < totalSize - 1; i++) {
            for (int j = 0; j < totalSize - i - 1; j++) {
                if (get(j) > get(j + 1)) {
                    int temp = get(j);
                    set(j, get(j + 1));
                    set(j + 1, temp);
                }
            }
        }
    }

    // sort by comparator
    public void sort(Comparator<Integer> comparator) {
        for (int i = 0; i < totalSize - 1; i++) {
            for (int j = 0; j < totalSize - i - 1; j++) {
                if (comparator.compare(get(j), get(j + 1)) > 0) {
                    int temp = get(j);
                    set(j, get(j + 1));
                    set(j + 1, temp);
                }
            }
        }
    }

    // compare collections
    @Override
    public int compareTo(CustomArrayList other) {
        return this.size() - other.size();
    }
}