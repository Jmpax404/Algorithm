public class SimpleMinPQ {
    int capacity;
    int[] pq;
    int size;

    public SimpleMinPQ(int capacity) {
        this.capacity = capacity;
        pq = new int[capacity + 1];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void push(int x) {
        pq[++size] = x;
        int cur = size;
        int parent = cur / 2;
        while (parent > 0 && pq[parent] > x) {
            swap(cur, parent);
            cur = parent;
            parent = parent / 2;
        }
    }

    public int peek() {
        return pq[1];
    }

    public int pop() {
        int value = pq[1];
        pq[1] = pq[size--];
        int cur = 1;
        int j = cur * 2;
        while (j <= size) {
            if (j < size && pq[j] > pq[j + 1]) {
                j++;
            }
            if (pq[cur] <= pq[j]) {
                break;
            }
            swap(cur, j);
            cur = j;
            j = cur * 2;
        }

        return value;
    }

    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
        SimpleMinPQ pq = new SimpleMinPQ(10);
        pq.push(3);
        pq.push(4);
        pq.push(1);
        pq.push(2);
        System.out.println(pq.pop());
        System.out.println(pq.pop());
        System.out.println(pq.pop());
        System.out.println(pq.pop());
    }

}
