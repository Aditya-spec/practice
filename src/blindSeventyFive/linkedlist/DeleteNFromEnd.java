package blindSeventyFive.linkedlist;

public class DeleteNFromEnd {
    public Node deleteNode(Node head, int n){
        Node fastP = head;
        Node slowP = head;
        for (int i =0; i< n;i++){
            fastP = fastP.next;
        }
        if(fastP.next == null){
            return head;
        }
        while (fastP.next != null){
            slowP = slowP.next;
            fastP = fastP.next;
        }
        Node delNode = slowP.next;
        slowP.next = slowP.next.next;
        delNode = null;
        return head;
    }
}
