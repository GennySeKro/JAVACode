package Tree;

import UItilsClass.TreeNode;

import java.util.HashMap;

public class T437 {
    /*
    路径之和Ⅲ
     */

    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        dfs(root, map, targetSum, 0L);
        return res;
    }

    private void dfs(TreeNode root, HashMap<Long, Integer> map, int targetSum, long tempSum) {
        if (root == null){
            return;
        }

        tempSum += root.val;
        res += map.getOrDefault(tempSum - targetSum, 0);
        map.merge(tempSum, 1, Integer::sum);
        dfs(root.left, map, targetSum, tempSum);
        dfs(root.right, map, targetSum, tempSum);
        map.merge(tempSum, -1, Integer::sum);
    }
}
