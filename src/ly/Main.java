package ly;

import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> p, val;
    static {
        int max = (int)1e4 + 5;
        p = new HashMap<>();
        val = new HashMap<>();
        int[][] dp = new int[3][max];
        int[] idx= new int[max];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            for(int i = 2; i <= n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                List<Integer> list1 = p.getOrDefault(a, new ArrayList<>());
                list1.add(b);
                List<Integer> list2 = p.getOrDefault(i, new ArrayList<>());
                list2.add(b);
                p.put(a, list1);
                p.put(b, list2);

                list1 = val.getOrDefault(a, new ArrayList<>());
                list1.add(b);
                list2 = val.getOrDefault(i, new ArrayList<>());
                list2.add(b);
                p.put(a, list1);
                p.put(b, list2);
            }
        }
    }
}
