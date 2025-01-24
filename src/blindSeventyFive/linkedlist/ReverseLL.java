package blindSeventyFive.linkedlist;

public class ReverseLL {
    public Node reverseLinkedList(Node head){
        Node temp = head;
        Node prev = null;
        while(temp != null){
            head = head.next;
            temp.next = prev;
            prev = temp;
            temp = head;
        }
        return head;
    }
}

