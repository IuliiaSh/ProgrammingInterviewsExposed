package TreesAndGraphs;

import java.util.Stack;

public class PreorderTraversal {
    public static void traversePreorderRecursive(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value);
        traversePreorderRecursive(root.left);
        traversePreorderRecursive(root.right);
    }

    public static void traversePreorder(Node root) {
        Stack<Node> toBeTraversed = new Stack();
        toBeTraversed.push(root);
        Node current;
        while (!toBeTraversed.isEmpty()) {
            current = toBeTraversed.pop();
            System.out.println(current.value);
            if (current.right != null) {
                toBeTraversed.push(current.right);
            }
            if (current.left != null) {
                toBeTraversed.push(current.left);
            }
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

        traversePreorderRecursive(first);
        traversePreorder(first);
    }
}
