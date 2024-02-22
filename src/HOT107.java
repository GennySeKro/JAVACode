import java.util.*;

public class HOT107 {
    /*
    二叉树的层序遍历Ⅱ
     */

    public class TreeNode {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> itemList = new ArrayList<Integer>();
            int len = queue.size();

            while (len > 0){
                TreeNode tempNode = queue.poll();
                itemList.add(tempNode.val);
                if (tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                if(tempNode.right != null){
                    queue.offer(tempNode.right);
                }
                len--;
            }
            stack.push(itemList);
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
