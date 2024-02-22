import org.junit.Test;

public class HOT543 {
    /*
    二叉树的直径
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

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return -1;
        }
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        max = Math.max(max,left + right);
        return Math.max(left,right);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        diameterOfBinaryTree(root);
    }

}
