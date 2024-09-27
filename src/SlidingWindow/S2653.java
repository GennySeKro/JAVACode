package SlidingWindow;

public class S2653 {
    /*
    滑动子数组的美丽值
     */

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] res = new int[nums.length - k + 1];
        int[] valueCount = new int[101];

        for (int i = 0;i < k - 1;i++){
            valueCount[nums[i] + 50]++;
        }

        for(int i = k - 1;i < nums.length;i++){
            valueCount[nums[i] + 50]++;

            int val = x;
            for (int j = 0;j < 50;j++){
                val -= valueCount[j];
                if (val <= 0){
                    res[i -k + 1] = j -50;
                    break;
                }
            }
            valueCount[nums[i - k + 1] + 50]--;
        }
        return res;

    }
}
