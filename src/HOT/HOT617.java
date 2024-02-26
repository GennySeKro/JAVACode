package HOT;

public class HOT617 {
    /*
    合并二叉树
    时间复杂度O(min(n,m))
    空间复杂度O(min(n,m)
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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return root1 == null ? root2 : root1;
        }
        dfs(root1,root2);
        return root1;
    }

    private void dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return;
        }
        if(root1 != null && root2 != null){
            root1.val = root1.val + root2.val;
        }
        if(root1 == null && root2 != null){
            return;
        }
        if(root1 != null && root2 == null){
            return;
        }
        dfs(root1.left,root2.left);
        if(root1.left == null && root2.left != null){
            root1.left = root2.left;
        }
        dfs(root1.right,root2.right);
        if(root1.right == null && root2.right != null){
            root1.right = root2.right;
        }
    }
}
