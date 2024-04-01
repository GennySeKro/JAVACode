package rating1500_1700;

public class G2424 {
    /*
    最长上传前缀
     */

    class LUPrefix {
        int[] arr;
        int ans = 0;

        public LUPrefix(int n) {
            arr = new int[n + 2];
        }

        public void upload(int video) {
            arr[video] = 1;
        }

        public int longest() {
            while (arr[ans + 1] == 1) {
                ans++;
            }
            return ans;
        }
    }
}
