package LCR;
import HOT.ListNode;

public class LCR021 {
    /*
    删除链表的倒数第N个节点
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode l = dummy;
        ListNode r = dummy;
        for(int i = 0; i < n - 1; i++){
            r = r.next;
        }
        while(r.next != null){
            r = r.next;
            if(r.next == null){
                l.next = l.next.next;
                break;
            }else l = l.next;
        }
        return dummy.next;
    }
}
