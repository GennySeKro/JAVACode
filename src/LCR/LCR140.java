package LCR;
import HOT.ListNode;

public class LCR140 {
    /*
    训练计划Ⅱ
     */

    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode res = head;
        ListNode p = head;
        int k = 0;
        while (k != cnt - 1){
            p = p.next;
        }
        while (p != null){
            p = p.next;
            res = res.next;
        }
        return res;
    }
}
