package LinkedLists;

public class StackImplementation {
    private Node head;

    public void push(int value) {
        head = new Node(head, value);
    }

    public int pop () {
        int result = -1;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        StackImplementation stack = new StackImplementation();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class Node {
    Node next;
    int value;

    public Node(Node next, int value) {
        this.next = next;
        this.value = value;
    }
}