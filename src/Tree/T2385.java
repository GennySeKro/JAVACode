package Tree;

import UItilsClass.TreeNode;

public class T2385{
    /*
    感染二叉树需要的总时间
     */

    private int ans;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return ans;
    }

    private int[] dfs(TreeNode node, int start) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] leftRes = dfs(node.left, start);
        int[] rightRes = dfs(node.right, start);
        int lLen = leftRes[0], lFound = leftRes[1];
        int rLen = rightRes[0], rFound = rightRes[1];
        if (node.val == start) {
            // 计算子树 start 的最大深度
            // 注意这里和方法一的区别，max 后面没有 +1，所以算出的也是最大深度
            ans = Math.max(lLen, rLen);
            return new int[]{1, 1}; // 找到了 start
        }
        if (lFound == 1 || rFound == 1) {
            // 只有在左子树或右子树包含 start 时，才能更新答案
            ans = Math.max(ans, lLen + rLen); // 两条链拼成直径
            // 保证 start 是直径端点
            return new int[]{(lFound == 1 ? lLen : rLen) + 1, 1};
        }
        return new int[]{Math.max(lLen, rLen) + 1, 0};
    }
}
