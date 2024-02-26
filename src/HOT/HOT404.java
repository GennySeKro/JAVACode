package HOT;

import org.junit.Test;

public class HOT404 {
    /*
    左叶子之和
     */

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null){
            return 0;
        }
        dfs(root, null);
        return sum;
    }

    private void dfs(TreeNode root, TreeNode father) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null && father.left == root){
            sum = sum + root.val;
            return;
        }
        dfs(root.left, root);
        dfs(root.right, root);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        System.out.println(sumOfLeftLeaves(root));
    }
}
