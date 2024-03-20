package HOT;

public class HOT789 {
    /*
    逃脱者阻碍
     */


    public boolean escapeGhosts(int[][] gs, int[] t) {
        int cur = dist(0, 0, t[0], t[1]);
        for (int[] g : gs) {
            if (dist(g[0], g[1], t[0], t[1]) <= cur) return false;
        }
        return true;
    }

    int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
