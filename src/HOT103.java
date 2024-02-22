import java.util.*;

public class HOT103 {
    /*
    二叉树的锯齿形层序遍历
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        int k = 1;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int len = queue.size();

            while (len > 0){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
                len--;
            }
            if (k % 2 == 0){
                Collections.reverse(list);
            }
            res.add(list);
            k++;
        }
        return res;
    }
}
