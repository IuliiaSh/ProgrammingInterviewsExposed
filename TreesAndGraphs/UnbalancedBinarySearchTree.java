package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class UnbalancedBinarySearchTree {
    public static Node balanceBinarySearchTree(Node root) {
        Node newRoot = root.left;
        Node current = newRoot;
        while (current.right != null) {
            current = current.right;
        }
        current.right = root;
        root.left = null;
        return newRoot;
    }

    public static void levelOrderTraverse(Node root) {
        Queue<Node> currentQueue = new LinkedList();
        Queue<Node> nextQueue = new LinkedList();
        currentQueue.offer(root);
        Node current;
        while (!currentQueue.isEmpty()) {
            while (!currentQueue.isEmpty()) {
                current = currentQueue.remove();
                System.out.println(current.value);
                if (current.left != null) {
                    nextQueue.offer(current.left);
                }
                if (current.right != null) {
                    nextQueue.offer(current.right);
                }
            }
            currentQueue = nextQueue;
            nextQueue = new LinkedList();
        }
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);

        sixth.left = fourth;
        sixth.right = seventh;
        fourth.left = second;
        fourth.right = fifth;
        second.left = first;
        second.right = third;

        Node newRoot = balanceBinarySearchTree(sixth);
        levelOrderTraverse(newRoot);
    }
}
