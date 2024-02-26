package HOT;

import org.junit.Test;

public class HOT3036 {
    /*
    匹配模式数组的子数组数目Ⅱ
    数据量远大于Ⅰ
     */

    public int countMatchingSubarrays(int[] nums, int[] p) {
        int n=nums.length,m=p.length;
        int[] next = new int[m+1];
        int iN = next[0] = -1;
        //构造next数组,同kmp算法
        for (int i = 0; i < m; i++) {
            while (iN >= 0 && p[i] != p[iN]) iN = next[iN];
            iN++;
            next[i+1] = iN;
            if(i<m-1&&p[i+1]==p[iN]) next[i+1] = next[iN];
        }
        int ans = 0;
        //进行kmp匹配，将(nums[i], nums[i-1])构造为kmp中的一个字符
        //接下来就是纯粹的kmp匹配了
        for (int i = 1,j=0; i < n; i++) {
            int com = Integer.compare(nums[i], nums[i-1]);
            while (j>=0 && p[j] != com) j = next[j];
            j++;
            if(j==m) {
                ans ++;
                j = next[j];
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(countMatchingSubarrays(new int[]{481251768,481251768,481251768,463564806}, new int[]{0}));
    }
}
