package HOT;

public class HOT88 {
    /*
    合并两个有序数组
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0){
            for (int i = 0;i < n;i++){
                nums1[i] = nums2[i];
            }
        }else {
            int mLen = m - 1, nLen = n - 1;
            for (int i = m + n - 1;mLen >= 0 && nLen >= 0;i--){
                if (nums1[mLen] > nums2[nLen]){
                    nums1[i] = nums1[mLen];
                    mLen--;
                }else {
                    nums1[i] = nums2[nLen];
                    nLen--;
                }
            }
            if (mLen == -1){
                for (int i = nLen;i >= 0;i--){
                    nums1[i] = nums2[i];
                }
            }
        }

    }
}
