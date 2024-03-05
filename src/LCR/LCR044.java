package LCR;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import HOT.TreeNode;

public class LCR044 {
    /*
    在每个树行中找最大值
     */

    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0;i < len;i++){
                TreeNode temp = queue.poll();
                max = Math.max(max, temp.val);
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
