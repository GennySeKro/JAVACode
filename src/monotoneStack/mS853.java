package monotoneStack;

import java.util.ArrayDeque;

public class mS853 {
    /*
    车队
     */

    public int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[target];
        for (int i = 0;i < position.length; i++){
            time[position[i]] = (target - position[i]) / (double)speed[i];
        }

        ArrayDeque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < target; i++){
            if (time[i] > 0){
                while (!stack.isEmpty() && stack.peek() <= time[i]){
                    stack.pop();
                }
                stack.push(time[i]);
            }
        }

        return stack.size();
    }
}
