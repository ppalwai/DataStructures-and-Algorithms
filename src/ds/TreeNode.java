package ds;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }

    public void insert(int input) {
        if(input > data) {
            if(right == null) {
                right = new TreeNode(input);
            } else {
                right.insert(input);
            }
        } else {
            if(left == null) {
                left = new TreeNode(input);
            } else {
                left.insert(input);
            }
        }
    }

    public TreeNode get(int input) {
        if(data == input) return this;

        if(input > data) {
            if(right == null) return null;
            return right.get(input);
        } else {
            if(left == null) return null;
            return left.get(input);
        }
    }

    //inOrder Printing L/C/R (DFS)
    public void printInOrder() {
        if(left != null) left.printInOrder();
        System.out.print(data + " ");
        if(right != null) right.printInOrder();
    }

    //preOrder Printing C/L/R (DFS)
    public void printPreOrder() {
        System.out.print(data + " ");
        if(left != null) left.printPreOrder();
        if(right != null) right.printPreOrder();
    }

    //postOrder Printing L/R/C (DFS)
    public void printPostOrder() {
        if(left != null) left.printPostOrder();
        if(right != null) right.printPostOrder();
        System.out.print(data + " ");
    }

    //levelOrder Printing
    public void printLevelOrder() {
        Queue<TreeNode> queue = new LinkedList();

        System.out.print(data + " ");
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            System.out.print(tn.data + " ");
            if(null != tn.left) queue.offer(tn.left);
            if(null != tn.right) queue.offer(tn.right);
        }
    }

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(10);

        tn.insert(4);
        tn.insert(20);

        tn.insert(2);
        tn.insert(6);

        tn.insert(15);
        tn.insert(21);

        System.out.print("InOrder Traversal (L/C/R): ");
        tn.printInOrder();
        System.out.println();

        System.out.print("PreOrder Traversal (C/L/R): ");
        tn.printPreOrder();
        System.out.println();

        System.out.print("PostOrder Traversal (L/R/C): ");
        tn.printPostOrder();
        System.out.println();

        System.out.print("LevelOrder Traversal BFS: ");
        tn.printLevelOrder();
        System.out.println();

        assert tn.get(4).data == 4;

        assert tn.get(100) == null;
    }
}