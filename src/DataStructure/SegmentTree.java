package DataStructure;

public class SegmentTree {

    int[] tree;
    int[] nums;
    int n;

    public SegmentTree(int[] nums){
        this.nums = nums;
        n = nums.length;
        tree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1);
    }

    //建立线段树
    private void buildSegmentTree(int node, int left, int right) {
        if (left == right){
            tree[node] = nums[left];
            return;
        }
        int mid = left + ((right - left) >> 1);
        int leftChildIndex = 2 * node + 1;
        int rightChildIndex = 2 * node + 2;

        buildSegmentTree(leftChildIndex, left, mid);
        buildSegmentTree(rightChildIndex, mid + 1, right);
        tree[node] = tree[leftChildIndex] + tree[rightChildIndex];
    }

    //查询区间和
    public int queryRange(int queryLeft, int queryRight){
        return querySegmentTree(0, 0, n -1, queryLeft, queryRight);
    }

    //单点更新：nums[index] = val
    public void update(int index, int val){
        updateSegmentTree(0, 0, n -1, index, val);
    }

    //更新线段树
    private void updateSegmentTree(int node, int left, int right, int idx, int val){
        //叶子节点
        if (left == right) {
            nums[idx] = val;
            tree[node] = val;
        }else {
            int mid = left + (right - left) / 2;
            if (idx <= mid){
                updateSegmentTree(node * 2 + 1, left, mid, idx, val);
            }else {
                updateSegmentTree(node * 2 + 2, mid + 1, right, idx, val);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    //查询线段树
    private int querySegmentTree(int node, int left, int right, int queryLeft, int queryRight){
        if (right < queryLeft || left > queryRight){
            return 0;
        }

        //当前区间包含在目标区间内，直接返回当前区间和
        if (left == right || queryLeft <= left && queryRight >= right){
            return tree[node];
        }

        int mid = left + ((right - left) >> 1);

        //合并左右子树的查询结果
        return querySegmentTree(2 * node + 1, left, mid, queryLeft, queryRight) +
                querySegmentTree(2 * node + 2, mid + 1, right, queryLeft, queryRight);

    }

}


