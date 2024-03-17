package LCR;

public class LCR013 {
    /*
    二维区域和检索-矩阵不可变
     */

    class NumMatrix {

        private int[][] matrix;
        private int[][] preMatrix;
        public NumMatrix(int[][] matrix) {
            this.matrix = new int[matrix.length][matrix[0].length];
            this.preMatrix = new int[matrix.length][matrix[0].length];
            for (int i = 0;i < matrix.length;i++){
                int sum = 0;
                for (int j = 0;j < matrix[0].length;j++){
                    this.matrix[i][j] = matrix[i][j];
                    sum = sum + matrix[i][j];
                    this.preMatrix[i][j] = sum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1;i <= row2;i++){
                sum = sum + preMatrix[i][col2] - preMatrix[i][col1] + matrix[i][col1];
            }
            return sum;
        }
    }
}
