package blindSeventyFive.linkedlist;

public class MergeTwoSortedLinkedList {
    public Node mergeList(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Ensure l1 starts with the smaller value
        if (l2.data < l1.data) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        Node res = l1; // The head of the merged list

        while (l1 != null && l2 != null) {
            Node temp = null;
            while (l1 != null && l1.data <= l2.data) {
                temp = l1;
                l1 = l1.next;
            }

            // Connect the last node processed in l1 to l2
            temp.next = l2;

            // Swap l1 and l2 to maintain order
            Node tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        return res;
    }
}

