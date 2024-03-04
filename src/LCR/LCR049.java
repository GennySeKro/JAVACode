package LCR;
import HOT.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LCR049 {
    /*
    求根节点到叶节点数字之和
     */

    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    int cur = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        path.add(root.val);
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null){
            sum = sum + cur;
        }
        dfs(root.left);
        dfs(root.right);
        cur = cur / 10;
        path.removeLast();
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }
}
