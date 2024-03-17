package LCR;
import HOT.TreeNode;

public class LCR175 {
    /*
    计算二叉树的深度
     */

    public int calculateDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            return Math.max(dfs(root.left), dfs(root.right)) + 1;
        }
    }
}
