import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HOT429 {
    /*
    N叉树的层序遍历
     */

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            while(len > 0){
                Node temp = queue.poll();
                list.add(temp.val);
                for(int i = 0;i < temp.children.size();i++){
                    queue.offer(temp.children.get(i));
                }
                len--;
            }
            res.add(list);
        }
        return res;
    }
}
