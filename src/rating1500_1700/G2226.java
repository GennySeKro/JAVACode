package rating1500_1700;

public class G2226 {
    /*
    每个小孩最多能分到多少糖果
     */

    public int maximumCandies(int[] candies, long k) {
        long sum=0L;  //求和
        for(int i:candies){
            sum+=(long)(i);
        }
        if(sum<k){
            return 0;
        }
        if(sum==k){
            return 1;
        }
        long temp=0l;   //用于存放满足条件的最大值
        long max=sum/k;   //求平均值
        long l=1l,r=max;
        while(l<=r){     //二分
            long mid=(l+r)/2;

            //循环，遍历，计算是否满足条件
            long cnt=0l;
            for(int num:candies){
                cnt+=(long)(num)/mid;
            }

            if(cnt>=k){  //假如满足条件，更新temp，移动l；否则移动r
                temp=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return (int)temp;
    }
}
