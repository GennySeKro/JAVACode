public class HOT104 {
    /*
    二叉树的最大深度
     */

    public static class TreeNode {
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

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.left)+1,depth(root.right)+1);
    }

    private int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left+1,right+1);
    }
}
