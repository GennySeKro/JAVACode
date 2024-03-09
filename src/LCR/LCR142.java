package LCR;
import HOT.ListNode;

public class LCR142 {
    /*
    训练计划Ⅳ
     */

    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null){
            ListNode p = new ListNode(-1);
            ListNode res = p;
            while (l1 != null && l2 != null){
                ListNode k;
                if (l1.val < l2.val){
                    k = l1;
                    l1 = l1.next;
                }else {
                    k = l2;
                    l2 = l2.next;
                }
                k.next = null;
                p.next = k;
                p = p.next;
            }
            while (l1 != null){
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            }
            while (l2 != null){
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
            return res.next;
        }else {
            return l1 == null ? l2 : l1;
        }
    }
}
