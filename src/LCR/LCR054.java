package LCR;
import HOT.TreeNode;

public class LCR054 {
    /*
    把二叉搜索树转换为累加树
     */


    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.right);
        sum = sum + root.val;
        root.val = sum;
        dfs(root.left);
    }
}
