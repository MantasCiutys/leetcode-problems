package LinkedList;

/*
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    private static Node mergeTwoLists(Node n1, Node n2) {
        // Creating pointers
        Node p1 = n1;
        Node p2 = n2;
        Node out = null;

        while (p1 != null || p2 != null) {
            // get values
            int p1Val = Integer.MAX_VALUE;
            int p2Val = Integer.MAX_VALUE;
            int outVal = 0;

            if (p1 != null) p1Val = p1.val;
            if (p2 != null) p2Val = p2.val;

            if (p1Val <= p2Val) {
                outVal = p1Val;
                p1 = p1.next;
            }

            if (p2Val <= p1Val) {
                outVal = p2Val;
                p2 = p2.next;
            }

        }

        return out;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node four = new Node(4);

        one.next = two;
        two.next = four;

        Node one2 = new Node(1);
        Node three2 = new Node(3);
        Node four2 = new Node(4);

        one2.next = three2;
        three2.next = four2;

        Node out = mergeTwoLists(one, one2);

        //Node.printLinkedList(one);
        //Node.printLinkedList(one2);
        Node.printLinkedList(out);
    }
}
