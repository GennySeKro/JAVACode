package LCR;
import HOT.ListNode;

public class LCR171 {
    /*
    训练计划Ⅴ
     */

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int Alen = 0, Blen = 0;
        ListNode A = headA, B = headB;
        while (A != null){
            Alen++;
            A = A.next;
        }
        while (B != null){
            Blen++;
            B = B.next;
        }
        A = headA;
        B = headB;
        while (A != B && A != null && B != null){
            if (Alen == Blen){
                A = A.next;
                B = B.next;
            } else if (Alen > Blen) {
                A = A.next;
                Alen--;
            }else {
                B = B.next;
                Blen--;
            }
        }
        if (A != null && B != null){
            return A;
        }else {
            return null;
        }
    }
}
