package LinkedLists;

import java.util.LinkedList;
import java.util.Queue;

public class ListFlatteningUnflattening {
    private static MultilevelNode head;
    private static MultilevelNode tail;

    public static void flatten() {
        Queue<MultilevelNode> queue = new LinkedList();
        queue.offer(head);
        MultilevelNode currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            while (currentNode != null) {
                tail = currentNode;
                if (currentNode.child != null) {
                    queue.offer(currentNode.child);
                }

                if (!queue.isEmpty() && currentNode.next == null) {
                    currentNode.setNext(queue.remove());
                }
                currentNode = currentNode.next;
            }
        }
    }

    public static void unflatten() {
        Queue<MultilevelNode> queue = new LinkedList();
        queue.offer(head);
        MultilevelNode currentNode;
        tail = null;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            while (currentNode != null) {
                if (currentNode.child != null) {
                    if (tail == null) {
                        tail = currentNode.child.previous;
                    }
                    currentNode.child.removePrevious();
                    queue.offer(currentNode.child);
                }
                currentNode = currentNode.next;
            }
        }
    }

    public static void main(String[] args) {
        MultilevelNode five = new MultilevelNode(5);
        MultilevelNode three = new MultilevelNode(3);
        MultilevelNode two = new MultilevelNode(2);
        MultilevelNode four = new MultilevelNode(4);
        MultilevelNode six = new MultilevelNode(6);
        MultilevelNode one = new MultilevelNode(1);
        MultilevelNode seven = new MultilevelNode(7);

        five.setNext(three);
        three.setNext(two);
        four.setNext(six);

        five.setChild(four);
        four.setChild(seven);
        two.setChild(one);

        head = five;
        tail = seven;

        ListFlatteningUnflattening linkedList = new ListFlatteningUnflattening();
        linkedList.flatten();
        linkedList.unflatten();

        MultilevelNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }
}

class MultilevelNode {
    MultilevelNode next;
    MultilevelNode previous;
    MultilevelNode child;
    int value;

    public MultilevelNode(int value) {
        this.value = value;
    }

    public void setNext(MultilevelNode next) {
        this.next = next;
        next.previous = this;
    }

    public void removePrevious() {
        this.previous.next = null;
        this.previous = null;
    }

    public void setChild(MultilevelNode child) {
        this.child = child;
    }
}
