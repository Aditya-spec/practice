package blindSeventyFive.linkedlist;

public class FindMiddle {
    public Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
