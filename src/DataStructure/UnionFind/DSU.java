package DataStructure.UnionFind;

public class DSU {

    //记录子节点数量
    int[] size;

    //记录根节点
    int[] parents;

    public DSU(int n){
        parents = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++){
            parents[i] = i;
            size[i] = 1;
        }
    }

    private int find(int x){
        if (parents[x] != x){
            parents[x] = find(parents[x]);
        }

        return parents[x];
    }

    private boolean union(int x, int y){
        int parentX = find(x), parentsY = find(y);
        if (parentX == parentsY){
            return false;
        }

        if (size[parentX] > size[parentsY]){
            parents[parentsY] = parentX;
            size[parentX] += size[parentsY];
        }else {
            parents[parentX] = parentsY;
            size[parentsY] += size[parentX];
        }
        return true;
    }
}
