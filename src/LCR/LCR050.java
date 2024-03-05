package LCR;
import HOT.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LCR050 {
    /*
    路径总和Ⅲ
     */

    /*
    dfs判断从每一个节点向下是否存在符合条件的和
    时间复杂度O(n * n)
    空间复杂度O(n)
     */
    class one{
        int res = 0;
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null){
                return 0;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                dfs(temp, targetSum);
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
            }
            return res;
        }

        private void dfs(TreeNode root, long targetSum) {
            if (root == null){
                return;
            }
            if (targetSum == root.val){
                res = res + 1;
            }
            dfs(root.left, targetSum - root.val);
            dfs(root.right, targetSum - root.val);
        }
    }

    /*
    前缀和优化dfs
    时间复杂度O(n)
    空间复杂度O(n)
     */
    class two{
        Map<Long, Integer> sumCountMap = new HashMap<Long, Integer>();

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            sumCountMap.put(0L, 1);
            return getCounts(root, root.val, targetSum);
        }

        private int getCounts(TreeNode node, long sum, int targetSum) {
            int count = sumCountMap.getOrDefault(sum - targetSum, 0);
            sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                count += getCounts(left, sum + left.val, targetSum);
            }
            if (right != null) {
                count += getCounts(right, sum + right.val, targetSum);
            }
            sumCountMap.put(sum, sumCountMap.get(sum) - 1);
            return count;
        }
    }


    @Test
    public void test(){
        TreeNode root = new TreeNode(715827882);
        root.left = new TreeNode(715827882);
        root.left.left = new TreeNode(715827882);
        System.out.println(new one().pathSum(root, -1));
    }
}
