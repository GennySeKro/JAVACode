package rating1500_1700;

import java.util.PriorityQueue;

public class G2241 {
    /*
    设计一个ATM机
     */

    class ATM {
        private  final int TYPES = 5;
        private  final int[] AMOUNTS = {20, 50, 100, 200, 500};
        private long[] counts;

        public ATM() {
            counts = new long[TYPES];
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < TYPES; i++) {
                counts[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] output = new int[TYPES];
            for (int i = TYPES - 1; i >= 0 && amount > 0; i--) {
                int curr = (int) Math.min(amount / AMOUNTS[i], counts[i]);
                output[i] = curr;
                amount -= AMOUNTS[i] * output[i];
            }
            if (amount != 0) {
                return new int[]{-1};
            }
            for (int i = 0; i < TYPES; i++) {
                counts[i] -= output[i];
            }
            return output;
        }
    }
}
