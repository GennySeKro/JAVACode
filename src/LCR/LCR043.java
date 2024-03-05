package LCR;
import HOT.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LCR043 {
    /*
    完全二叉树插入器
     */

    class CBTInserter {

        TreeNode root;
        Queue<TreeNode> queue;
        public CBTInserter(TreeNode root) {
            this.root = root;
            this.queue = new ArrayDeque<>();

            Queue<TreeNode> nodeQueue = new ArrayDeque<>();
            nodeQueue.offer(root);
            while (!nodeQueue.isEmpty()){
                TreeNode temp = nodeQueue.poll();
                if (temp.left != null){
                    nodeQueue.offer(temp.left);
                }
                if (temp.right != null){
                    nodeQueue.offer(temp.right);
                }
                if (!(temp.left != null && temp.right != null)){
                    queue.offer(temp);
                }
            }
        }

        public int insert(int v) {
            TreeNode child = new TreeNode(v);
            TreeNode node = queue.peek();
            int ret = node.val;
            if (node.left == null){
                node.left = child;
            }else {
                node.right = child;
                queue.poll();
            }
            queue.offer(child);
            return ret;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
