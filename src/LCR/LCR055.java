package LCR;

import HOT.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LCR055 {
    /*
    二叉搜索树迭代器
     */

    class BSTIterator {

        private TreeNode cur;
        private Deque<TreeNode> queue;
        public BSTIterator(TreeNode root) {
            cur = root;
            queue = new LinkedList<>();
        }

        public int next() {
            while (cur != null){
                queue.push(cur);
                cur = cur.left;
            }
            cur = queue.pop();
            int ret = cur.val;
            cur = cur.right;
            return ret;
        }

        public boolean hasNext() {
            return cur != null || !queue.isEmpty();
        }
    }
}
