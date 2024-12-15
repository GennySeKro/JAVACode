package Leetcode.week.week428;

public class Q1 {
    /*
    按下时间最长的按钮
     */

    public int buttonWithLongestTime(int[][] events) {
        int res = events[0][1];
        int index = events[0][0];

        for (int i = 1;i < events.length;i++){
            int temp = events[i][1] - events[i - 1][1];
            if (temp > res){
                res = temp;
                index = events[i][0];
            } else if (temp == res) {
                if (index > events[i][0]){
                    index = events[i][0];
                }
            }
        }

        return index;
    }
}
