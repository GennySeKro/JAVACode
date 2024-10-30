package DFS;

public class DFS03 {
    /*
    主题空间
     */

    private boolean flag = true; // 当前主题是不是符合要求的主题
    private int[][] check; // 是否遍历过

    public int largestArea(String[] grid) {
        check = new int[grid.length][grid[0].length()];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) != '0' && check[i][j] == 0) {
                    int area = dfs(grid, i, j, grid[i].charAt(j));
                    if (flag) { // 如果这个主题空间符合要求。则可以更新答案
                        res = Math.max(res, area);
                    }
                    flag = true;
                }
            }
        }
        return res;
    }

    // dfs遍历当前主题空间元素。
    private int dfs(String[] grid, int i, int j, char k) {
        // 如果位置不合法，或者当前位置是 '0'。说明当前主题空间靠近走廊，不符合要求
        if (!isValid(grid, i, j) || grid[i].charAt(j) == '0') {
            flag = false;
            return 0;
        }
        // 位置合法且不是0。
        // 如果当前位置被访问过了，或者不是元素k的话，说明不是一个主题的
        if (check[i][j] == 1 || grid[i].charAt(j) != k) {
            return 0;
        }
        check[i][j] = 1;
        return 1 + dfs(grid, i, j + 1, k) + dfs(grid, i, j - 1, k) + dfs(grid, i + 1, j, k) + dfs(grid, i - 1, j, k);
    }

    // 位置是否合法
    private boolean isValid(String[] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[i].length();
    }
}
