package HOT;

import java.util.LinkedList;
import java.util.Queue;

public class HOT513 {
    /*
    找树左下角的指
     */

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int res = root.val;
        while (!queue.isEmpty()){
            int k = 0;
            int len = queue.size();

            while(len > 0){
                TreeNode temp = queue.poll();
                if (k == 0){
                    k = 1;
                    res = temp.val;
                }
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
                len--;
            }
        }
        return res;
    }
}
