import java.util.HashMap;
import java.util.Map;

public class HOT141 {
    /*
    环形链表
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        boolean k = false;
        while(head != null){
            if(map.containsKey(head)){
                k = true;
                break;
            }else {
                map.put(head,1);
            }
            head = head.next;
        }
        return k;
    }

    /*
    优化：快慢指针
     */

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
