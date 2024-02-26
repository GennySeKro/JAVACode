package HOT;

public class HOT222 {
    /*
    完全二叉树的节点个数
    递归：左子树节点个数 + 右子树节点个数 + 1
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

    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        return dfs(root.left) + dfs(root.right) + 1;
    }

}
