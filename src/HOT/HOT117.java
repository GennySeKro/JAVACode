package HOT;

import java.util.LinkedList;
import java.util.Queue;

public class HOT117 {
    /*
    填充每个节点的下一个右侧节点指针
     */

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            while (len > 0){
                Node temp = queue.poll();
                Node next;
                if (len == 1){
                    next = null;
                }else {
                    next = queue.peek();
                }
                temp.next = next;
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
                len--;
            }
        }
        return root;
    }
}
