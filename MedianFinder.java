import java.util.*;


//2024.8.11
public class MedianFinder {
    PriorityQueue<Integer> leftBigHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    PriorityQueue<Integer> rightSmallHeap = new PriorityQueue<>();
    double median = 0;

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (num >= median) {
            rightSmallHeap.offer(num);
        } else {
            leftBigHeap.offer(num);
        }
    }

    public double findMedian() {
        int leftSize = leftBigHeap.size();
        int rightSize = rightSmallHeap.size();
        if (rightSize > leftSize + 1) {//右往左挪
            while (rightSmallHeap.size() > leftBigHeap.size() + 1) {
                leftBigHeap.offer(rightSmallHeap.poll());
            }

        } else if (leftSize > rightSize) {//左往右挪
            while (leftBigHeap.size() > rightSmallHeap.size()) {
                rightSmallHeap.offer(leftBigHeap.poll());
            }
        }//否则不用挪，不挪，中位数也就不变，因为没有删除数字的操作

        //重新设置中位数
        if (rightSmallHeap.size() == leftBigHeap.size() + 1) {
            median = rightSmallHeap.peek();
        } else {//在调用 findMedian 之前，数据结构中至少有一个元素。不会出现两个size为0
            median = (leftBigHeap.peek() + rightSmallHeap.peek()) / 2.0;
        }
        return median;
    }
}





/// 2024.2.3
public class MedianFinder {
    public static void main(String[] args) {

    }
}
class MedianFinder2 {
    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>();

    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }
        int leftSize = left.size();
        int rightSize = right.size();
        if (leftSize - rightSize > 1) {
            right.add(left.poll());
        } else if (rightSize - leftSize > 1) {
            left.add(right.poll());
        }
    }

    public double findMedian() {
        int leftSize = left.size();
        int rightSize = right.size();
        if (leftSize == rightSize) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return leftSize > rightSize ? left.peek() : right.peek();
        }
    }
}

class MedianFinder1 {
    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> a - b);

    public void addNum(int num) {
        if (left.size() == right.size()) {
            if (left.isEmpty() || num <= right.peek()) {
                left.add(num);
            } else {
                left.add(right.poll());
                right.add(num);
            }
        } else {
            if (num >= left.peek()) {
                right.add(num);
            } else {
                right.add(left.poll());
                left.add(num);
            }
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}

class MedianFinder0 {//只有最后一个用例超时了
    Node head;
    Node mid;
    int half = 0;//-1 denotes -0.5, 0 denotes 0, 1 denotes +0.5, 2 denotes +1 and -2 denotes -1 thus needs to move mid.

    class Node {
        Node prev;
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public MedianFinder0() {
        head = new Node(0);
    }

    public void addNum(int num) {
        if (mid == null) {
            Node node = new Node(num);
            node.prev = head;
            node.next = head;
            head.next = node;
            head.prev = node;
            mid = node;
            return;
        }
        Node cur = mid;
        Node node = new Node(num);
        if (num >= mid.value) {
            while (cur != head && cur.value <= num) {
                cur = cur.next;
            }
            node.prev = cur.prev;
            node.next = cur;
            cur.prev.next = node;
            cur.prev = node;
            half += 1;
            if (half == 2) {
                mid = mid.next;
                half = 0;
            }
        } else {
            while (cur != head && cur.value >= num) {
                cur = cur.prev;
            }
            node.prev = cur;
            node.next = cur.next;
            cur.next.prev = node;
            cur.next = node;
            half -= 1;
            if (half == -2) {
                mid = mid.prev;
                half = 0;
            }
        }
    }

    public double findMedian() {
        if (half == 0) {
            return mid.value;
        } else if (half == 1) {
            return (mid.value + mid.next.value) / 2.0;
        } else {
            return (double) (mid.value + mid.prev.value) / 2;
        }
    }
}