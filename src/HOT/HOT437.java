package HOT;

import java.util.HashMap;
import java.util.Map;

public class HOT437 {
    /*
    路径总和Ⅲ
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


    /*
    递归
    时间复杂度O(N*N)
    空间复杂度O(N)
     */
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int ret = rootSum(root,targetSum);
        ret = ret + rootSum(root.left,targetSum);
        ret = ret + rootSum(root.right,targetSum);
        return ret;
    }

    private int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if(root == null){
            return 0;
        }
        int val = root.val;
        if(val == targetSum){
            ret++;
        }
        ret = ret + rootSum(root.left,targetSum - val);
        ret = ret + rootSum(root.right,targetSum - val);
        return ret;
    }

    /*

     */
    public int pathSum1(TreeNode root, int targetSum) {
        Map<Long,Integer> prefix = new HashMap<>();
        prefix.put(0L,1);
        return dfs(root,prefix,0L,targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> prefix, Long curr, int targetSum) {
        if(root == null){
            return 0;
        }
        int ret = 0;
        curr = curr + root.val;

        ret = prefix.getOrDefault(curr - targetSum,0);
        prefix.put(curr,prefix.getOrDefault(curr,0) + 1);
        ret = ret + dfs(root.left,prefix,curr,targetSum);
        ret = ret + dfs(root.right,prefix,curr,targetSum);

        prefix.put(curr,prefix.getOrDefault(curr,0) - 1);

        return ret;
    }
}
