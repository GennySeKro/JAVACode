package LCR;
import HOT.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class LCR151 {
    /*
    彩灯装饰Ⅲ
     */

    public List<List<Integer>> decorateRecord(TreeNode root) {
        int flag = 0;
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> path = new ArrayList<>();

            while (len > 0){
                TreeNode cur = queue.poll();
                path.add(cur.val);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
                len--;
            }
            if (flag == 1){
                List<Integer> temp = new ArrayList<>();
                for (int i = 0;i < path.size();i++){
                    temp.add(path.get(path.size() - 1 - i));
                }
                list.add(temp);
                flag = 0;
            }else {
                list.add(path);
                flag = 1;
            }
        }
        return list;
    }
}
