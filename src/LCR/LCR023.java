package LCR;
import HOT.ListNode;

public class LCR023 {
    /*
    相交链表
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        ListNode A = headA;
        ListNode B = headB;
        while (lenA > lenB){
            A = A.next;
            lenA--;
        }
        while (lenB > lenA){
            B = B.next;
            lenB--;
        }
        while (A != null){
            if (A == B){
                return A;
            }else {
                A = A.next;
                B = B.next;
            }
        }
        return null;
    }

    private int len(ListNode headA) {
        if (headA == null){
            return 0;
        }
        return len(headA.next) + 1;
    }
}
