package blindSeventyFive.linkedlist;

public class DetectCycle {
    public boolean DetectCycle(Node head){
        Node fast = head;
        Node slow  = head;
        while(fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
