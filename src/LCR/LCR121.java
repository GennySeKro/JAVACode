package LCR;

public class LCR121 {
    /*
    寻找目标值
     */

    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        int i = plants.length - 1, j = 0;
        while (i >= 0 && j < plants[0].length){
            if (plants[i][j] == target){
                return true;
            }else if (plants[i][j] > target){
                i--;
            }else {
                j++;
            }
        }
        return false;
    }
}
