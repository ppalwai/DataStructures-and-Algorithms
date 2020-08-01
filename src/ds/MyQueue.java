package ds;

public class MyQueue<T> {
    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    int size;
    Node<T> head;
    Node<T> tail;

    public void offer(T data) {
        Node<T> node = new Node<>(data);

        if(head == null) {
            head = node;
        }

        if(tail != null) {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public T peek() {
        if(head == null) return null;
        return head.data;
    }

    public T poll() {
        if(head == null) return null;
        T rv = head.data;
        this.head = head.next;
        size--;

        if(head == null) tail = null;
        return rv;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node<T> node = head;
        while (node != null) {
            if(node == head) {
                sb.append(node.data);
            } else {
                sb.append(", " + node.data);
            }
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue();

        queue.offer(0);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue);
        assert queue.toString().equals("0, 1, 2, 3");
        assert queue.size == 4;

        assert queue.peek().equals(0);

        assert queue.poll().equals(0);
        assert queue.toString().equals("1, 2, 3");
        assert queue.size == 3;
    }
}