package Leetcode.week.week450;

import java.util.Arrays;

public class Q2 {
    /*\
    数位和排序需要的最小交换次数
     */

    public int minSwaps(int[] nums) {
        //存储数位和
        int[] digits = new int[nums.length];
        //存储原始下标
        Integer[] sort = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++){
            digits[i] = numToSum(nums[i]);
            sort[i] = i;
        }

        //Arrays.sort()针对对象类型排序，所以自定义排序需要用包装类实现
        Arrays.sort(sort, (a, b) -> digits[a] == digits[b] ?
                Integer.compare(nums[a], nums[b]) : Integer.compare(digits[a], digits[b]));

        DSU dsu = new DSU(nums.length);
        //将每个下标与其排序后位置下标union
        for (int i = 0; i < nums.length; i++){
            dsu.union(i, sort[i]);
        }

        //统计每个根节点对应的分量大小
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            count[dsu.find(i)] += 1;
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++){
            if (count[i] > 0){
                res += count[i] - 1;
            }
        }

        return res;
    }


    private int numToSum(int num) {
        int res = 0;
        while (num != 0){
            res += num % 10;
            num /= 10;
        }

        return res;
    }

    class DSU{
        int[] parent;

        public DSU(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        //查找根节点
        public int find(int x){
            if (parent[x] != x){
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        //合并x所在集合与y所在集合
        public void union(int x, int y){
            parent[find(x)] = find(y);
        }
    }
}
