package LCR;

import HOT.TreeNode;

public class LCR01 {
    /*
    二叉树中的最大路径和
     */

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return res;
    }

    private int maxGain(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);

        int curGain = root.val + leftGain + rightGain;

        res = Math.max(res, curGain);
        return root.val + Math.max(leftGain, rightGain);
    }
}
