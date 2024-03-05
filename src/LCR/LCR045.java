package LCR;
import HOT.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LCR045 {
    /*
    找树左下角的的值
     */

    /*
    层序遍历，返回最后一层的第一个节点
    时间复杂度O(n)
    空间复杂度O(n)
     */
    class one{
        List<List<Integer>> res = new ArrayList<>();

        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int len = queue.size();
                List<Integer> temp = new ArrayList<>();

                for (int i = 0;i < len;i++){
                    TreeNode k = queue.poll();
                    temp.add(k.val);
                    if (k.left != null){
                        queue.offer(k.left);
                    }
                    if (k.right != null){
                        queue.offer(k.right);
                    }
                }
                res.add(temp);
            }
            return res.get(res.size() - 1).get(0);
        }
    }

    /*
    深度遍历，实时更新深度和对应的值
    时间复杂度O()
    空间复杂度O()
     */
    class two{
        int res = 0, curDepth = -1;
        public int findBottomLeftValue(TreeNode root){
            dfs(root, 0);
            return res;
        }

        private void dfs(TreeNode root, int depth) {
            if (root == null){
                return;
            }
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
            if (depth > curDepth){
                curDepth = depth;
                res = root.val;
            }
        }
    }
}
