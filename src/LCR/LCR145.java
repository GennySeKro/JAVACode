package LCR;
import HOT.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LCR145 {
    /*
    判断对称二叉树
     */

    public boolean checkSymmetricTree(TreeNode root) {
        TreeNode left = root;
        TreeNode right = root;
        return dfs(left, right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null && right != null || left != null && right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

}
