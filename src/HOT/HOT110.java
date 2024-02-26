package HOT;

public class HOT110 {
    /*
    平衡二叉树
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

    int k = 0;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        if (k == 1){
            return false;
        }else {
            return true;
        }

    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) >= 2){
            k = 1;
        }
        return Math.max(left, right) + 1;

    }
}
