package LCR;
import java.util.*;
import HOT.TreeNode;

public class LCR046 {
    /*
    二叉树的右视图
     */

    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();

            for (int i = 0;i < len;i++){
                TreeNode temp = queue.poll();
                if (i == len - 1){
                    res.add(temp.val);
                }
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
            }
        }
        return res;
    }
}
