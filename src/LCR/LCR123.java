package LCR;
import HOT.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LCR123 {
    /*
    图书整理
     */

    public int[] reverseBookList(ListNode head) {
        if (head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0;i < res.length;i++){
            res[i] = stack.pop().val;
        }
        return res;
    }
}
