package HOT;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HOT637 {
    /*
    二叉树的层平均值
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int len = queue.size();
            double k = len;
            double sum = 0;

            while(len > 0){
                TreeNode temp = queue.poll();
                sum = sum + temp.val;
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
                len--;
            }
            DecimalFormat df = new DecimalFormat("#.#####");
            res.add(new Double(df.format(sum / k)));
        }
        return res;
    }
}
