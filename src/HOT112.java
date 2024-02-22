public class HOT112 {
    /*
    路径总和
     */

    public boolean hasPathSum(TreeNode root, int sum){
        if (root == null) return false; // 为空退出

        // 叶子节点判断是否符合
        if (root.left == null && root.right == null) return root.val == sum;

        // 求两侧分支的路径和
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
