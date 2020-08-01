package ds;

import java.util.Stack;

public class MyLinkedList<T> {
    class Node<T> {
        T data;
        Node<T> next;
        Node(T t) {
            this.data = t;
        }
    }

    Node<T> head;
    int size;

    //Add a new node
    public void add(T t) {
        if (null == head) {
            head = new Node<>(t);
            size++;
            return;
        }
        Node<T> node = head;
        while(node.next != null) {
            node = node.next;
        }
        node.next = new Node(t);
        size++;
    }

    public void prepend(T t) {
        if (null == head) {
            head = new Node<>(t);
            size++;
            return;
        }
        Node newHead = new Node(t);
        newHead.next = head;
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
        Node<T> node = head;
        while(node.next != null) {
            if(node.next.data.equals(t)) {
                node.next = node.next.next;
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

        while(node.next != null) {
            if(i == index - 1) {
                Node<T> newNode = new Node(data);
                newNode.next = node.next;
                node.next = newNode;
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

    private MyLinkedList<T> reverse() {
        Stack<T> stack = new Stack<>();

        Node<T> node = head;
        while (node != null) {
            stack.push(node.data);
            node = node.next;
        }

        MyLinkedList<T> rv = new MyLinkedList<>();
        while (!stack.empty()) {
            rv.add(stack.pop());
        }
        return rv;
    }

    public MyLinkedList<T> reverse2() {
        if(this.size <= 1) return this;

        Node<T> prev = null;
        Node<T> curr = head;
        Node<T> next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
        return this;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.prepend(0);

        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(2);
        myLinkedList.add(3);

        System.out.println(myLinkedList);
        assert myLinkedList.toString().equals("0, 1, 2, 2, 3");
        assert myLinkedList.size == 5;

        myLinkedList.prepend(-1);

        System.out.println(myLinkedList);
        assert myLinkedList.toString().equals("-1, 0, 1, 2, 2, 3");
        assert myLinkedList.size == 6;

        assert myLinkedList.get(0) == -1;
        assert myLinkedList.get(10) == null;

        System.out.println(myLinkedList);
        assert myLinkedList.toString().equals("-1, 0, 1, 2, 2, 3");
        assert myLinkedList.get(3) == 2;

        myLinkedList.delete(-1);

        System.out.println(myLinkedList);
        assert myLinkedList.toString().equals("0, 1, 2, 2, 3");
        assert myLinkedList.size == 5;

        myLinkedList.delete(2);

        System.out.println(myLinkedList);
        assert myLinkedList.toString().equals("0, 1, 2, 3");
        assert myLinkedList.size == 4;

        myLinkedList.delete(3);

        System.out.println(myLinkedList);
        assert myLinkedList.toString().equals("0, 1, 2");
        assert myLinkedList.size == 3;

        myLinkedList.insert(0, -1);

        System.out.println(myLinkedList);
        assert myLinkedList.toString().equals("-1, 0, 1, 2");
        assert myLinkedList.size == 4;

        myLinkedList.insert(2, 2);

        System.out.println(myLinkedList);
        assert myLinkedList.toString().equals("-1, 0, 2, 1, 2");
        assert myLinkedList.size == 5;

        myLinkedList.insert(5, 3);

        System.out.println(myLinkedList);
        assert myLinkedList.toString().equals("-1, 0, 2, 1, 2, 3");
        assert myLinkedList.size == 6;

        myLinkedList = myLinkedList.reverse();
        System.out.println("reverse: " + myLinkedList);
        assert myLinkedList.toString().equals("3, 2, 1, 2, 0, -1");
        assert myLinkedList.size == 6;


        myLinkedList = myLinkedList.reverse2();
        System.out.println("reverse2: " + myLinkedList);
        assert myLinkedList.toString().equals("-1, 0, 2, 1, 2, 3");
        assert myLinkedList.size == 6;
    }
}