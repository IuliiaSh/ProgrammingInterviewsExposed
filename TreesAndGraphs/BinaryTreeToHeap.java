package TreesAndGraphs;

import java.util.*;

public class BinaryTreeToHeap {
    public static Node getHeap(Node root) {
        Node[] array = getSortedArray(root);
        cleanLinks(array);
        return getBalancedBinaryTree(array);
    }

    private static Node getBalancedBinaryTree(Node[] array) {
        Node root = array[0];
        Queue<Node> toBeAdded = new LinkedList();
        toBeAdded.offer(root);
        System.out.println(root.value);
        int i = 1;
        Node next;
        while (i < array.length) {
            next = toBeAdded.remove();
            next.left = array[i];
            toBeAdded.offer(array[i]);
            System.out.println(array[i].value);
            i++;

            if (i == array.length) {
                break;
            }
            next.right = array[i];
            toBeAdded.offer(array[i]);
            System.out.println(array[i].value);
            i++;
        }
        return root;
    }

    private static void cleanLinks(Node[] array) {
        Node currentNode;
        for (int i = 0; i < array.length; i++) {
            currentNode = array[i];
            currentNode.left = null;
            currentNode.right = null;
        }
    }

    private static Node[] getSortedArray(Node root) {
        ArrayList<Node> arrayList = new ArrayList();
        getArray(root, arrayList);
        Node[] array = arrayList.toArray(new Node[arrayList.size()]);
        Arrays.sort(array, Comparator.comparingInt(o -> ((Node) o).value));
        return array;
    }

    public static void getArray(Node root, ArrayList<Node> array) {
        if (root == null) {
            return;
        }

        array.add(root);
        getArray(root.left, array);
        getArray(root.right, array);
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

        getHeap(first);
    }
}
