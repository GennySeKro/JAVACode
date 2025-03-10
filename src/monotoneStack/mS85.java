package monotoneStack;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class mS85 {
    /*
    最大矩形
     */

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        ArrayList<int[]> allHeights = new ArrayList<>();
        for (int i = m - 1; i >= 0; i--){
            int[] heights = new int[n + 2];
            for (int j = 0; j < n; j++){
                int k = i;
                while (k >= 0 && matrix[k][j] =='1'){
                    heights[j + 1]++;
                    k--;
                }
            }
            allHeights.add(heights);
        }

        int res = 0;
        for (int[] heights : allHeights){
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < heights.length; i++){
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                    int cur = stack.pop();
                    int val = heights[cur] * (i - stack.peek() - 1);
                    res = Math.max(res, val);
                }
                stack.push(i);
            }
        }

        return res;
    }
}
