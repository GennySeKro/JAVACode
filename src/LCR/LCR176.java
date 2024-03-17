package LCR;
import HOT.TreeNode;

public class LCR176 {
    /*
    判断是否为平衡二叉树
     */

    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        dfs(root);
        return flag;
    }

    private int dfs(TreeNode root) {
        if (!flag){
            return 0;
        }
        if (root == null){
            return 0;
        }
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        if (Math.abs(left - right) > 1){
            flag = false;
        }
        return Math.max(left, right);
    }
}
