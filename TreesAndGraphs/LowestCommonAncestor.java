package TreesAndGraphs;

public class LowestCommonAncestor {
    public static Node findLowestCommonAncestor(Node root, Node first, Node second) {
        if (first.value < root.value && second.value < root.value) {
            return findLowestCommonAncestor(root.left, first, second);
        } else if (first.value > root.value && second.value > root.value) {
            return findLowestCommonAncestor(root.right, first, second);
        } else {
            return root;
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

        fifth.left = third;
        fifth.right = seventh;
        third.left = first;
        third.right = fourth;
        seventh.left = sixth;
        seventh.right = eighth;
        first.right = second;
        eighth.right = ninth;

        System.out.println(findLowestCommonAncestor(fifth, sixth, ninth).value);
    }
}
