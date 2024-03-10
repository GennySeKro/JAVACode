package LCR;

public class LCR146 {
    /*
    螺旋遍历二位数组
     */

    public int[] spiralArray(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[0];
        }
        int rows = array.length, columns = array[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = array[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = array[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = array[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = array[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
