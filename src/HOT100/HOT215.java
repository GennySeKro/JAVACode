package HOT100;

public class HOT215 {
    /*
    数组中的第K个最大元素
     */

    public int findKthLargest(int[] nums, int k) {
        int[] buckets = new int[20001];

        for (int i = 0;i < nums.length;i++){
            buckets[nums[i] + 10000]++;
        }

        for (int i = 20000;i >= 0;i--){
            k = k - buckets[i];
            if (k <= 0){
                return i - 10000;
            }
        }

        return 0;
    }

    public int findKthLargestQuickSort(int[] nums, int k){
        int n = nums.length;
        return quickSort(nums, 0, n - 1, n - k);
    }

    private int quickSort(int[] nums, int left, int right, int k) {
        if (left == right){
            return nums[k];
        }

        int x = nums[left], i = left - 1, j = right + 1;

        while (i < j){
            while (nums[i] < x){
                i++;
            }

            while (nums[j] > x){
                j--;
            }

            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        if (k <= j){
            return quickSort(nums, left, j, k);
        }else {
            return quickSort(nums, j + 1, right, k);
        }
    }
}
