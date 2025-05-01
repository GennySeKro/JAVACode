package DP;

public class D3259 {
    /*
    超级饮料的最大强化能量
     */

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] res = new long[n][2];
        res[0][0] = energyDrinkA[0];
        res[0][1] = energyDrinkB[0];
        res[1][0] = res[0][0] + energyDrinkA[1];
        res[1][1] = res[0][1] + energyDrinkB[1];
        res[2][0] = Math.max(res[1][0] , res[0][1]) + energyDrinkA[2];
        res[2][1] = Math.max(res[1][1] , res[0][0]) + energyDrinkB[2];

        for (int i = 3; i < n; i++){
            res[i][0] =Math.max(res[i - 1][0], res[i - 2][1]) + energyDrinkA[i];
            res[i][1] = Math.max(res[i - 1][1], res[i - 2][0]) + energyDrinkB[i];
        }

        return Math.max(res[n - 1][0], res[n - 1][1]);
    }
}
