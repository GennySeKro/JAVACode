package LCR;

public class LCR189 {
    /*
    设计机械累加器
     */

    public int mechanicalAccumulator(int target) {
        boolean x = target > 1 && (target += mechanicalAccumulator(target - 1)) > 0;
        return target;
    }
}
