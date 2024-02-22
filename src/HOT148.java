import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HOT148 {
    /*
    排序链表
     */

    public ListNode sortList(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode p = head;
        if (head == null){
            return null;
        }
        while (p != null){
            res.add(p.val);
            p = p.next;
        }
        int[] value = new int[res.size()];
        for (int i = 0;i < res.size();i++){
            value[i] = res.get(i);
        }
        Arrays.sort(value);
        p = head;
        int i = 0;
        while (p != null){
            p.val = value[i];
            i++;
            p = p.next;
        }
        return head;
    }

}
