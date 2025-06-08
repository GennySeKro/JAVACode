package SlidingWindow;
import org.junit.Test;

import java.util.*;

public class S1023 {
    /*
    驼峰式匹配
     */

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();

        for (int i = 0;i < queries.length;i++){
            String tempStr = queries[i];
            int targetIndex = 0, pattenIndex = 0;
            while (targetIndex < tempStr.length() && pattenIndex < pattern.length()){
                if (tempStr.charAt(targetIndex) == pattern.charAt(pattenIndex)){
                    targetIndex++;
                    pattenIndex++;
                }else {
                    if (tempStr.charAt(targetIndex) <= 'z' && tempStr.charAt(targetIndex) >= 'a'){
                        targetIndex++;
                    }else {
                        res.add(false);
                        break;
                    }
                }
            }
            while (pattenIndex == pattern.length() && targetIndex < tempStr.length()){
                if (tempStr.charAt(targetIndex) <= 'Z' && tempStr.charAt(targetIndex) >= 'A'){
                    res.add(false);
                    break;
                }else {
                    targetIndex++;
                }
            }
            if (pattenIndex == pattern.length() && targetIndex == tempStr.length()){
                res.add(true);
            }else if (res.size() != i + 1){
                res.add(false);
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBaT"));
    }
}
