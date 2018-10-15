package LinkedLists;

public class MaintainTailPointer {
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean delete(Node node) {
        if (head == null) {
            return false;
        }

        if (head == node) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node previous = head;
            while (previous.next != null && previous.next != node) {
                previous = previous.next;
            }

            if (previous.next == null) {
                return false;
            }

            previous.next = previous.next.next;
            if (previous.next == null) {
                tail = previous;
            }
        }
        return true;
    }

    public boolean insertAfter(Node node, int data) {
        Node newNode;
        if (node == null) {
            newNode = new Node(head, data);
            head = newNode;
        } else {
            Node previous = head;
            while (previous != null && previous != node) {
                previous = previous.next;
            }

            if (previous == null) {
                return false;
            }

            newNode = new Node(previous.next, data);
            previous.next = newNode;
        }

        if (newNode.next == null) {
            tail = newNode;
        }
        return true;
    }

    public static void main(String[] args) {
        MaintainTailPointer stack = new MaintainTailPointer();
        stack.insertAfter(null,1);
        System.out.println(stack.getHead().value);
        System.out.println(stack.getTail().value);
        System.out.println();

        stack.insertAfter(null,2);
        System.out.println(stack.getHead().value);
        System.out.println(stack.getTail().value);
        System.out.println();

        stack.delete(stack.getTail());
        System.out.println(stack.getHead().value);
        System.out.println(stack.getTail().value);
        System.out.println();

        stack.delete(stack.getHead());
        System.out.println(stack.isEmpty());
    }
}
