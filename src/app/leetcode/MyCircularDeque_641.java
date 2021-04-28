package app.leetcode;

/**
 * @author dimmy
 *
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *  
 *\
 * ["MyCircularDeque","insertFront","deleteLast","getRear","getFront","getFront","deleteFront","insertFront","insertLast","insertFront","getFront","insertFront"]
 * [[4],[9],[],[],[],[],[],[6],[5],[9],[],[6]]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyCircularDeque_641 {

    public class Node {
        int val;
        Node pre;
        Node next;

        public Node(int value) {
            val = value;
        }

    }

    public Node head;
    public Node tail;
    public int max;
    public int size;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque_641(int k) {
        max = k;
        size = 0;
        head = null;
        tail = null;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size == max) return false;
        if(head == null) {
            head = new Node(value);
            tail = head;
        } else {
            Node node = new Node(value);
            head.pre = node;
            node.next = head;
            head = node;
        }

        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size == max) return false;
        if(head == null) {
            head = new Node(value);
            tail = head;
        } else {
            Node node = new Node(value);
            node.pre = tail;
            tail.next = node;
            tail = tail.next;
        }

        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0) return false;
        head = head.next;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0) return false;
        if(size == 1) {
            head = null;
            tail = null;
            size = 0;
            return true;
        }

        Node node = tail;
        tail = node.pre;
        tail.next = null;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(size == 0) return -1;
        return head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size == 0) return -1;
        return tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == max;
    }
}
