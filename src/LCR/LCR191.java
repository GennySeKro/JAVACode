package LCR;

public class LCR191 {
    /*
    按规则计算统计结果
     */

    public int[] statisticalResult(int[] arrayA) {
        int size = arrayA.length;
        int multiSum = 1;
        boolean existZero = false; //标记是否有元素0
        int zeroCount = 0; //元素0的个数
        for(int i=0;i<size;i++){
            if(arrayA[i] == 0){
                existZero = true;
                zeroCount++;
                continue;
            }
            multiSum *= arrayA[i];
        }
        int[] arrayB = new int[size];
        for(int i=0;i<size;i++){
            if(arrayA[i] !=0 && existZero){
                arrayB[i] = 0;
            } else if(arrayA[i] == 0 && zeroCount > 1){
                arrayB[i] = 0;
            } else if(arrayA[i] == 0){
                arrayB[i] = multiSum;
            } else {
                arrayB[i] = multiSum/arrayA[i];
            }
        }
        return arrayB;
    }

}
