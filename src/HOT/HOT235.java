package HOT;

public class HOT235 {
    /*
    二叉搜索树的最近公共祖先
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = dfs(root.left, p ,q);
        TreeNode right = dfs(root.right, p , q);

        if (left == null && right == null){
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        }else {
            return root;
        }
    }
}
