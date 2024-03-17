package LCR;
import HOT.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LCR149 {
    /*
    彩灯装饰记录
     */

    List<Integer> list = new ArrayList<>();
    public int[] decorateRecord(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();

            while (len > 0){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
                len--;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
