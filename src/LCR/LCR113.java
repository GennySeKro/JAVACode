package LCR;

import java.util.*;

public class LCR113 {
    /*
    课程表Ⅱ
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] in=new int[numCourses];
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        for(int pre[]:prerequisites){//统计所有课程的入度（存入in数组）以及后置节点（存入map）
            List<Integer> list = map.getOrDefault(pre[1], new ArrayList<>());
            list.add(pre[0]);
            map.put(pre[1],list);
            in[pre[0]]++;
        }
        Queue<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){//入度为0的节点入队
                queue.offer(i);
            }
        }
        int []result=new int[numCourses];
        int index=0;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            result[index++]=poll;//进修poll课程
            //将该课程的后置课程节点入度减一
            List<Integer> list = map.get(poll);
            if(list==null) continue;//没有后直节点 继续循环
            for(Integer course:list){
                in[course]--;
                if(in[course]==0){
                    queue.offer(course);
                }
            }
        }
        if(index!=numCourses) return new int[0];
        return result;
    }
}
