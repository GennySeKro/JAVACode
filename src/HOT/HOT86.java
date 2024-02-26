package HOT;

public class HOT86 {
    /*
    分隔链表
     */

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode big = new ListNode();
        ListNode p = head, bigHead = big, smallHead = small;
        while (p != null){
            ListNode k = p;
            if (p.val < x){
                p = p.next;
                k.next = null;
                small.next = k;
                small = small.next;
            }else {
                p = p.next;
                k.next = null;
                big.next = k;
                big = big.next;
            }
        }
        small.next = bigHead.next;
        return smallHead.next;
    }
}
