import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HOT2476 {
    /*
    二叉搜索树最近节点查询
     */

    /*
    暴力：超时
     */
    class one{
        List<Integer> value = new ArrayList<>();
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            dfs(root);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0;i < queries.size();i++){
                List<Integer> temp = new ArrayList<>();
                int min = -1,max = Integer.MAX_VALUE;
                for (int j = 0;j < value.size();j++){
                    if (Objects.equals(value.get(j), queries.get(i))){
                        min = value.get(j);
                        max = min;
                        break;
                    }else {
                        if (value.get(j) < queries.get(i)){
                            min = Math.max(min, value.get(j));
                        }else {
                            max = Math.min(max, value.get(j));
                        }
                    }
                }
                if (max == Integer.MAX_VALUE){
                    max = -1;
                }
                temp.add(min);
                temp.add(max);
                res.add(temp);
            }
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null){
                return;
            }
            dfs(root.left);
            value.add(root.val);
            dfs(root.right);
        }
    }

    /*
    中序遍历+二分查找
     */
    class two {
        List<Integer> value = new ArrayList<>();

        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            dfs(root);
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            for (int val : queries){
                int max = -1, min = -1;
                int idx = binarySearch(val);
                if (idx != value.size()){
                    max = value.get(idx);
                    if (value.get(idx) == val){
                        min = val;
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(min);
                        list.add(max);
                        res.add(list);
                        continue;
                    }
                }
                if (idx > 0){
                    min = value.get(idx - 1);
                }
                List<Integer> list2 = new ArrayList<Integer>();
                list2.add(min);
                list2.add(max);
                res.add(list2);
            }
            return res;
        }

        private int binarySearch(int val) {
            int low = 0, high = value.size();
            while (low < high){
                int mid = low + (high - low) / 2;
                if (value.get(mid) >= val){
                    high = mid;
                }else {
                    low = mid + 1;
                }
            }
            return low;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            value.add(root.val);
            dfs(root.right);
        }
    }
}
