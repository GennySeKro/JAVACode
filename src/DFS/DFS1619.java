package DFS;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS1619 {
    /*
    水域大小
     */

    public int[] pondSizes(int[][] land) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i < land.length;i++){
            for (int j = 0;j < land[0].length;j++){
                if (land[i][j] == 0){
                    list.add(DFS(land, i, j, 0));
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0;i < res.length;i++){
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    private Integer DFS(int[][] land, int i, int j, int area) {
        if (i < 0 || j < 0 || i > land.length - 1 || j > land[0].length - 1 || land[i][j] != 0){
            return 0;
        }

        land[i][j] = 1;
        return DFS(land, i - 1, j, area) + DFS(land, i - 1, j + 1, area) +
                DFS(land, i - 1, j - 1, area) + DFS(land, i, j + 1, area) +
                DFS(land, i + 1, j + 1, area) + DFS(land, i + 1, j, area) +
                DFS(land, i + 1, j - 1, area) + DFS(land, i, j - 1, area) + 1;
    }
}
