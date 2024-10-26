package Binary;

public class B378 {
    /*
    有序矩阵中第k小的元素
     */

    public int kthSmallest(int[][] matrix, int k) {
        int min = matrix[0][0], max = matrix[matrix.length - 1][matrix.length - 1];
        while (min <= max){
            int mid = (min + max) / 2;
            if(check(matrix, mid) >= k){
                max = mid - 1;
            }else {
                min = mid + 1;
            }
        }
        return min;
    }

    private int check(int[][] matrix, int mid) {
        int res = 0;
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix.length;j++){
                if (matrix[i][j] <= mid){
                    res++;
                }else {
                    break;
                }
            }
        }
        return res;
    }
}
