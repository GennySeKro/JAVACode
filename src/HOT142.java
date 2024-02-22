import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HOT142 {
    /*
    环形链表
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
    快慢指针
     */
    class one {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            if (head == null) {
                return head;
            }


            while (true) {
                if (fast.next == null || fast.next.next == null) {
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    ListNode pointer1 = head;
                    ListNode pointer2 = fast;

                    // 两个指针以相同速度前进，直到再次相遇
                    while (pointer1 != pointer2) {
                        pointer1 = pointer1.next;
                        pointer2 = pointer2.next;
                    }
                    // 返回相遇点，即为环的起始点
                    return pointer1;
                }
            }
        }
    }

    /*
    hashset
     */
    class two{
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            ListNode p = head;
            ListNode k = null;
            while(p != null){
                if(!set.contains(p)){
                    set.add(p);
                    p = p.next;
                }else {
                    k = p;
                    break;
                }
            }
            if(p == null){
                return null;
            }else {
                p = head;
                while(p.next != k){
                    p = p.next;
                }
                return p.next;
            }
        }
    }
}
