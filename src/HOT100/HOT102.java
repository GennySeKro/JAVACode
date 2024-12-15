package HOT100;

import UItilsClass.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class HOT102 {
    /*
    二叉树的层序遍历
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();

        if (root == null){
            return res;
        }

        treeNodeDeque.offer(root);
        while (!treeNodeDeque.isEmpty()){
            int len = treeNodeDeque.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            while (len > 0){
                TreeNode tempNode = treeNodeDeque.poll();
                tempList.add(tempNode.val);

                if (tempNode.left != null){
                    treeNodeDeque.offer(tempNode.left);
                }

                if (tempNode.right != null){
                    treeNodeDeque.offer(tempNode.right);
                }
                len--;
            }

            res.add(tempList);
        }
        return res;
    }
}
