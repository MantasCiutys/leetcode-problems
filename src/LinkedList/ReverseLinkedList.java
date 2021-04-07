package LinkedList;

public class ReverseLinkedList {

    private static void reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    public static void main(String[] args) {
        // input           2 -> 4 -> 6 -> 8
        // expected output 8 -> 6 -> 4 -> 2

        // SETUP
        Node two = new Node(2);
        Node four = new Node(4);
        Node six = new Node(6);
        Node eight = new Node(8);

        two.next = four;
        four.next = six;
        six.next = eight;
        eight.next = null;

        // PRINT OUT INPUT
        Node.printLinkedList(two);

        //REVERSE
        reverseLinkedList(two);

        // PRINT OUT OUTPUT
        Node.printLinkedList(eight);
    }



}
