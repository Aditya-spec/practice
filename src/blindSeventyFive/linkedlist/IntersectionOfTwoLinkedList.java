package blindSeventyFive.linkedlist;

public class IntersectionOfTwoLinkedList {
    public Node findIntersection(Node head1, Node head2){
        Node t1 = head1;
        Node t2 = head2;
        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
            if(t1 == t2){
                return t1;
            }if(t1 == null){
                t1 = head2;
            }if(t2 == null){
                t2 = head1;
            }
        }
        return null;
    }
}
