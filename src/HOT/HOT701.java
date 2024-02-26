package HOT;

public class HOT701 {
    /*
    二叉搜索树的插入操作
     */

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        dfs(root, val);
        return root;
    }

    private void dfs(TreeNode root, int val) {
        if (root.val > val){
            if (root.left == null){
                root.left = new TreeNode(val);
            }else {
                dfs(root.left, val);
            }
        }else {
            if (root.right == null){
                root.right = new TreeNode(val);
            }else {
                dfs(root.right, val);
            }
        }
    }
}
