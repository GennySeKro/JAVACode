package Binary;

public class B2080 {
    /*
    区间内查询数字的频率
     */

    class RangeFreqQuery {

        private int[] nums;

        public RangeFreqQuery(int[] arr) {
            nums = new int[arr.length];
            for (int i = 0;i < arr.length;i++){
                nums[i] = arr[i];
            }
        }

        public int query(int left, int right, int value) {
            int res = 0;
            for (int i = left;i <= right;i++){
                if (nums[i] == value){
                    res++;
                }
            }
            return res;
        }
    }
}
