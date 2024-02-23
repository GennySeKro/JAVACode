import org.junit.Test;

import java.util.*;

public class HOT2583 {
    /*
    二叉树中的第K大层的和
     */

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Long> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int len = queue.size();
            long sum = 0;
            while (len > 0){
                TreeNode temp = queue.poll();
                sum = sum + temp.val;
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
                len--;
            }
            res.add(sum);
        }
        if (k > res.size()){
            return -1;
        }else {
            Collections.sort(res);
            return res.get(res.size() - k);
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(kthLargestLevelSum(root, 2));
    }
}
