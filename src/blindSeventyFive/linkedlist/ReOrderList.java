package blindSeventyFive.linkedlist;

public class ReOrderList {
    public Node reOrderList(Node node){
        Node middle = getMiddle(node);
        Node second = reverseList(middle);
        Node head = reOrderList(node, second);
        return node;
    }

    private Node reOrderList(Node first, Node second) {

        Node c1 = first;
        Node c2 = second;
        Node f1 = null;
        Node f2 = null;

        while(c1 != null && c2 != null){
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }

        return c1;
    }

    private Node reverseList(Node head) {
        Node next = head;
        Node prev = null;
        Node curr = head;
        while (curr.next != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    private Node getMiddle(Node node) {
        Node fastP = node;
        Node slowP = node;
        while (fastP != null || fastP.next != null ){
            slowP = slowP.next;
            fastP = fastP.next.next;
        }
        return slowP.next;
    }
}
