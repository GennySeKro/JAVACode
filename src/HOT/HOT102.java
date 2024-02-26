package HOT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HOT102 {
    /*
    二叉树的层序遍历
     */

    public static class TreeNode {
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
    递归遍历
     */
    class one{
        List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            dns(root,0);
            return list;
        }

        public void dns(TreeNode node,int lever){
            if(node == null) return;
            if(list.size()==lever) list.add(new ArrayList<Integer>());

            list.get(lever).add(node.val);

            dns(node.left,lever+1);
            dns(node.right,lever+1);
        }
    }

    /*
    借助队列
     */
    class two{
        public List<List<Integer>> levelOrder(TreeNode root){
            List<List<Integer>> resList = new ArrayList<List<Integer>>();
            if (root == null){
                return new ArrayList<>();
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);

            while(!queue.isEmpty()){
                List<Integer> itemList = new ArrayList<Integer>();
                int len = queue.size();

                while (len > 0){
                    TreeNode tmpNode = queue.poll();
                    itemList.add(tmpNode.val);

                    if(tmpNode.left != null){
                        queue.offer(tmpNode.left);
                    }
                    if(tmpNode.right != null){
                        queue.offer(tmpNode.right);
                    }
                    len--;
                }

                resList.add(itemList);
            }
            return resList;
        }
    }
}
