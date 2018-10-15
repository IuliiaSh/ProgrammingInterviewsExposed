package LinkedLists;

public class NullOrCycle {
    private static Node head;

    public static boolean checkNullOrCycle() {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        NullOrCycle linkedList = new NullOrCycle();
        Node third = new Node(null, 3);
        Node second = new Node(third, 2);
        Node first = new Node(second, 1 );
        third.next = second;
        head = first;
        System.out.println(checkNullOrCycle());
    }
}
