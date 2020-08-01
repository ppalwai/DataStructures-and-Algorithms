package ds;

public class MyStack<T> {
    class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
        }
    }

    int size;
    Node<T> top;

    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if(top == null) return null;

        T rv = top.data;
        top = top.next;
        size--;
        return rv;
    }

    public T peek() {
        if(top == null) return null;

        T rv = top.data;
        return rv;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> curr = top;
        while (curr != null) {
            if(curr == top) {
                sb.append(curr.data);
            } else {
                sb.append(", " + curr.data);
            }
            curr = curr.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);
        assert stack.toString().equals("3, 2, 1");
        assert stack.size == 3;

        assert 3 == stack.peek();

        assert 3 == stack.pop();
        assert 2 == stack.pop();
        assert 1 == stack.pop();

        assert stack.size == 0;
    }
}