package LCR;
import HOT.ListNode;

public class LCR141 {
    /*
    训练计划Ⅲ
     */

    public ListNode trainningPlan(ListNode head) {
        ListNode p = head;
        ListNode res = new ListNode(-1);
        while (p != null){
            ListNode k = p;
            p = p.next;
            k.next = null;
            if (res.next == null){
                res.next = k;
            }else {
                k.next = res.next;
                res.next = k;
            }
        }
        return res.next;
    }
}
