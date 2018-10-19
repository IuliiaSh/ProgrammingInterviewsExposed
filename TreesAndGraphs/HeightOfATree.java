package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfATree {
    public static int findHeight(Node root) {
        int result = 0;
        Queue<Node> currentQueue = new LinkedList();
        Queue<Node> nextQueue = new LinkedList();
        currentQueue.offer(root);
        Node current;
        while (!currentQueue.isEmpty()) {
            result++;
            while (!currentQueue.isEmpty()) {
                current = currentQueue.remove();
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
        return result;
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eighth = new Node(8);
        Node ninth = new Node(9);

        first.left = second;
        first.right = third;
        second.left = fourth;
        third.left = fifth;
        third.right = sixth;
        fourth.left = seventh;
        fifth.left = ninth;
        seventh.right = eighth;

        System.out.println(findHeight(first));
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
