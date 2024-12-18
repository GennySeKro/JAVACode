package HOT100;

import UItilsClass.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class HOT199 {
    /*
    二叉树的右视图
     */

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()){
            int len = deque.size();
            while (len > 0){
                TreeNode node = deque.poll();
                if (node.left != null){
                    deque.offer(node.left);
                }
                if (node.right != null){
                    deque.offer(node.right);
                }
                len--;
                if (len == 0){
                    res.add(node.val);
                }
            }
        }

        return res;
    }
}
