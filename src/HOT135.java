import java.util.Arrays;

public class HOT135 {
    /*
    分发糖果
     */

    public int candy(int[] ratings) {
       int[] candysum = new int[ratings.length];
       int sum = 0;
       candysum[0] = 1;
       for(int i = 1;i < ratings.length;i++){
           candysum[i] = (ratings[i-1] < ratings[i]) ? candysum[i-1]+1 : 1;
       }
       for(int i = ratings.length-2;i >= 0;i--){
           if(ratings[i] > ratings[i+1]){
               candysum[i] = Math.max(candysum[i], candysum[i+1] + 1);
           }
           sum = sum + candysum[i];
       }
       return sum + candysum[ratings.length-1];
    }
}
