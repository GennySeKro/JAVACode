package LCR;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import HOT.TreeNode;

public class LCR150 {
    /*
    彩灯装饰记录Ⅱ
     */

    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> path = new ArrayList<>();

            while (len > 0){
                TreeNode cur = queue.poll();
                path.add(cur.val);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
                len--;
            }
            list.add(path);
        }
        return list;
    }
}
