package HOT100;

public class HOT11 {
    /*
    盛最多水的容器
     */

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0, tempValue = 0;
        while (left < right){
            tempValue = (right  - left) * Math.min(height[left], height[right]);
            res = Math.max(res, tempValue);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }

}
