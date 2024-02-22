public class HOT134 {
    /*
    加油站
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {
       int cursum = 0;
       int totalsum = 0;
       int index = 0;
       for(int i = 0;i < cost.length;i++){
           cursum = cursum + gas[i] - cost[i];
           totalsum = totalsum + gas[i] - cost[i];
           if(cursum < 0){
               index = (i+1)% gas.length;
               cursum = 0;
           }
       }
       if(totalsum < 0){
           return -1;
       }
       return index;
    }

}
