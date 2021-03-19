package LinkedList;

public class ReverseLinkedList {

    private static void reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // input           2 -> 4 -> 6 -> 8
        // expected output 8 -> 6 -> 4 -> 2

        // SETUP
        Node two = new Node(2);
        Node four = new Node(4);
        Node six = new Node(6);
        Node eight = new Node(8);

        two.setNext(four);
        four.setNext(six);
        six.setNext(eight);
        eight.setNext(null);

        // PRINT OUT INPUT
        printLinkedList(two);

        //REVERSE
        reverseLinkedList(two);

        // PRINT OUT OUTPUT
        printLinkedList(eight);
    }



}
