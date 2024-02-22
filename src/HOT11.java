public class HOT11 {
    /*
    盛水最多的容器
    0.暴力求解——容易超出内存和时间的限制
     */
    public int maxArea0(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        int len = height.length;
        int max = 0;
        int[][] value = new int[len][len];

        for (int i = 0; i < len; i++) {
            for(int j = 0; j < len ; j++){
                if(i == j){
                    value[i][j] = 0;
                }
                else {
                    value[i][j] = (j - i) * Math.min(height[i],height[j]);
                }

                if(value[i][j] > max){
                    max = value[i][j];
                }
            }
        }
        return max;
    }

    /*
        双指针，缩进较小的一端
     */
    public int maxArea1(int[] height){
        int left = 0;
        int right = height.length - 1;

        int Value;
        int max = 0;
        while(left != right){
            Value = (right - left) * Math.min(height[left],height[right]);
            if(height[left] < height[right]){
                left++;
            }
            else {
                right--;
            }
            max = Math.max(max,Value);
        }
        return max;
    }

}
