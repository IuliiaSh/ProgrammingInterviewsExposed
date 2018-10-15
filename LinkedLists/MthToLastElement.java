package LinkedLists;

public class MthToLastElement {
    private static Node head;

    public void add(int value) {
        head = new Node(head, value);
    }

    private static Node getMthToLast(int m) {
        Node first = head;
        int count = m;
        while (first != null && count > 0) {
            count--;
            first = first.next;
        }

        if (first == null) {
            return null;
        }

        Node second = head;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static void main(String[] args) {
        MthToLastElement linkedList = new MthToLastElement();
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);
        System.out.println(getMthToLast(1).value);
    }
}
