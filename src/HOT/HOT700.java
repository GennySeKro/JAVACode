package HOT;

public class HOT700 {
    /*
    二叉搜索树中的搜索
     */

    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root, val);
    }

    private TreeNode dfs(TreeNode root, int val) {
        if (root == null){
            return null;
        }else if (root.val == val){
            return root;
        } else if (root.val > val) {
            return dfs(root.left, val);
        }else {
            return dfs(root.right, val);
        }
    }
}
