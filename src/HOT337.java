import java.util.HashMap;
import java.util.Map;

public class HOT337 {
    /*
    打家劫舍Ⅲ
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
    递归:超出时间限制
     */
    class one{
        public int rob(TreeNode root){
            if (root == null){
                return 0;
            }

            int money = root.val;

            if(root.left != null){
                money = money + rob(root.left.left) + rob(root.left.right);
            }

            if(root.right != null){
                money = money + rob(root.right.left) + rob(root.right.right);
            }

            return Math.max(money,rob(root.left)+rob(root.right));
        }
    }

    /*
    动态规划
     */
    class two{
        Map<TreeNode,Integer> f = new HashMap<>();
        Map<TreeNode,Integer> g = new HashMap<>();

        public int rob(TreeNode root) {
            dfs(root);
            return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
        }

        private void dfs(TreeNode node) {
            if(node == null){
                return;
            }
            dfs(node.left);
            dfs(node.right);
            f.put(node,node.val + g.getOrDefault(node.left,0) + g.getOrDefault(node.right,0));
            g.put(node,Math.max(f.getOrDefault(node.left,0),g.getOrDefault(node.left,0)) +
                    Math.max(f.getOrDefault(node.right,0),g.getOrDefault(node.right,0)));
        }

    }

    /*
    动态优化
     */
    class three{
        public int rob(TreeNode root) {
           int[] result = robInternal(root);
           return Math.max(result[0],result[1]);
        }

        private int[] robInternal(TreeNode root) {
            if(root == null){
                return new int[2];
            }
            int[] result = new int[2];
            int[] left = robInternal(root.left);
            int[] right = robInternal(root.right);

            result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
            result[1] = left[0] + right[0] + root.val;

            return result;
         }
    }

}
