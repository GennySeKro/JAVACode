package SlidingWindow;

public class S11 {
    /*
    盛水最多的容器
     */

    public int maxArea(int[] height) {
        int res = 0, tempValue = 0;
        int left = 0, right = height.length - 1;

        while (left < right){
            tempValue = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, tempValue);
            if (height[left] > height[right]){
                right--;
            }else {
                left++;
            }
        }
        return res;
    }
}
