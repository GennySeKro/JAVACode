package rating1500_1700;

import org.junit.Test;

import java.util.*;

public class G1090 {
    /*
    受标签影响的最大值
     */

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        //记录标签使用次数
        Map<Integer, Integer> map = new HashMap<>();

        //
        List<int[]> list = new ArrayList<>();
        for (int i = 0;i < values.length;i++){
            list.add(new int[]{values[i], labels[i]});
        }
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(b[0], a[0]);
            }
        });
        int sum = 0;
        for (int i = 0;i < list.size();i++){
            if (map.getOrDefault(list.get(i)[1], 0) < useLimit && numWanted != 0){
                sum = sum + list.get(i)[0];
                map.put(list.get(i)[1], map.getOrDefault(list.get(i)[1], 0) + 1);
                numWanted = numWanted - 1;
            }
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(largestValsFromLabels(new int[]{2,1,5,2,8}, new int[]{2,0,2,2,2}, 3, 2));
    }
}
