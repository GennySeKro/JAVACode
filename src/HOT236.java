import java.util.ArrayList;
import java.util.List;

public class HOT236 {
    /*
    二叉树的最近公共祖先
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> a = new ArrayList<>();
        List<TreeNode> b = new ArrayList<>();

        dfs(root,p,a);
        dfs(root,q,b);

        TreeNode ans = null;
        for(int i = 0;i < Math.min(a.size(),b.size()) && a.get(i) == b.get(i);i++){
            ans = a.get(i);
        }
        return ans;
    }

    private boolean dfs(TreeNode curr, TreeNode t, List<TreeNode> path) {
        if(curr == null){
            return false;
        }
        path.add(curr);
        if(curr == t || dfs(curr.left,t,path) || dfs(curr.right,t,path)){
            return true;
        }else {
            path.remove(path.size() - 1);
            return false;
        }
    }

}
