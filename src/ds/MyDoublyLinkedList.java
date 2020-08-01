package ds;

public class MyDoublyLinkedList<T> {
    class Node<T> {
        T data;
        Node<T> next;
        Node<T> previous;
        Node(T t) {
            this.data = t;
        }
    }

    Node<T> head;
    Node<T> tail;
    int size;

    //Add a new node
    public void add(T t) {
        if (null == head) {
            head = new Node<>(t);
            tail = head;
            size++;
            return;
        }

        tail.next = new Node(t);
        tail.next.previous = tail;
        tail = tail.next;

        size++;
    }

    public void prepend(T t) {
        if (null == head) {
            head = new Node<>(t);
            tail = head;
            size++;
            return;
        }

        Node newHead = new Node(t);
        newHead.next = head;
        head.previous = newHead;
        this.head = newHead;
        size++;
    }

    public void delete(T t) {
        if (null == head) {
            return;
        }
        if(t == head.data) {
            head = head.next;
            size--;
            return;
        }
        if(t == tail.data) {
            tail.previous.next = null;
            tail = tail.previous;
            size--;
            return;
        }

        Node<T> node = head;
        while(node != null) {
            if(node.data.equals(t)) {
                node.previous.next = node.next;
                node.next.previous = node.previous;
                size--;
                return;
            }
            node = node.next;
        }
    }

    public void insert(int index, T data) {
        if(index == 0){
            prepend(data);
            return;
        }

        if(index == size) {
            add(data);
            return;
        }
        Node<T> node = head;
        int i = 0;

        while(node != null) {
            if(i == index) {
                Node<T> newNode = new Node(data);
                newNode.next = node;
                newNode.previous = node.previous;
                node.previous.next = node;
                node.previous = newNode;
                size++;
                return;
            }
            node = node.next;
            i++;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public T get(int index) {
        if(index == 0) return head.data;

        Node<T> current = head;
        int i = 0;

        while(current.next != null) {
            if(i == index) {
                return current.data;
            }
            current = current.next;
            i++;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = head;
        while(node != null) {
            if (sb.length() == 0) {
                sb.append(node.data);
            } else {
                sb.append(", " + node.data);
            }
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> myDoublyLinkedList = new MyDoublyLinkedList<>();

        myDoublyLinkedList.prepend(0);

        myDoublyLinkedList.add(1);
        myDoublyLinkedList.add(2);
        myDoublyLinkedList.add(2);
        myDoublyLinkedList.add(3);

        System.out.println(myDoublyLinkedList);
        assert myDoublyLinkedList.toString().equals("0, 1, 2, 2, 3");
        assert myDoublyLinkedList.size == 5;

        myDoublyLinkedList.prepend(-1);

        System.out.println(myDoublyLinkedList);
        assert myDoublyLinkedList.toString().equals("-1, 0, 1, 2, 2, 3");
        assert myDoublyLinkedList.size == 6;

        assert myDoublyLinkedList.get(0) == -1;
        assert myDoublyLinkedList.get(10) == null;

        System.out.println(myDoublyLinkedList);
        assert myDoublyLinkedList.toString().equals("-1, 0, 1, 2, 2, 3");
        assert myDoublyLinkedList.get(3) == 2;

        myDoublyLinkedList.delete(-1);
        System.out.println(myDoublyLinkedList);
        assert myDoublyLinkedList.toString().equals("0, 1, 2, 2, 3");
        assert myDoublyLinkedList.size == 5;

        myDoublyLinkedList.delete(2);

        System.out.println(myDoublyLinkedList);
        assert myDoublyLinkedList.toString().equals("0, 1, 2, 3");
        assert myDoublyLinkedList.size == 4;

        myDoublyLinkedList.delete(3);

        System.out.println(myDoublyLinkedList);
        assert myDoublyLinkedList.toString().equals("0, 1, 2");
        assert myDoublyLinkedList.size == 3;

        myDoublyLinkedList.insert(0, -1);

        System.out.println(myDoublyLinkedList);
        assert myDoublyLinkedList.toString().equals("-1, 0, 1, 2");
        assert myDoublyLinkedList.size == 4;

        myDoublyLinkedList.insert(2, 2);

        System.out.println(myDoublyLinkedList);
        assert myDoublyLinkedList.toString().equals("-1, 0, 1, 2, 2");
        assert myDoublyLinkedList.size == 5;

        myDoublyLinkedList.insert(5, 3);

        System.out.println(myDoublyLinkedList);
        assert myDoublyLinkedList.toString().equals("-1, 0, 1, 2, 2, 3");
        assert myDoublyLinkedList.size == 6;
    }
}