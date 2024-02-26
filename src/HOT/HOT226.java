package HOT;

public class HOT226 {
    /*
    反转二叉树
     */

    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
         }
    }

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if(root == null || root.right == null && root.left == null){
            return ;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode tmp = left;
        root.left = right;
        root.right = tmp;

        dfs(left);
        dfs(right);
    }
}
