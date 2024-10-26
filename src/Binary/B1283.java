package Binary;

public class B1283 {
    /*
    使结果不超过阈值的最小除数
     */

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;
        for (int num : nums){
            right = Math.max(right, num);
        }

        while (left <= right){
            int mid = (left + right) >>> 1;
            int sum = 0;
            for (int num : nums){
                sum += (num + mid - 1) / mid;
            }

            if (sum > threshold){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

}
