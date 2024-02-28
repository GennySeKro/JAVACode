package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR058 {
    /*
    我的日程安排表Ⅰ
     */

    class MyCalendar {

        private List<List<Integer>> res;
        public MyCalendar() {
            res = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int i = 0;i < res.size();i++){
                if (end <= res.get(i).get(0) || start >= res.get(i).get(1)){
                    continue;
                }else {
                    return false;
                }
            }
            res.add(new ArrayList<>(){{
                add(start);
                add(end);
            }});
            return true;
        }
    }
}
