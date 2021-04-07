package LinkedList;

public class Node {
    int val;
    Node next;

    Node() {}

    Node(int val) { this.val = val; }

    Node(int val, Node next) { this.val = val; this.next = next; }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
