package com.liang.面试常考算法题.codeTop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T114课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            indeg[prerequisites[i][0]]++;
            if (!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i]==0){
                queue.addLast(i);
            }
        }
        while (queue.size()>0){
            Integer temp = queue.removeFirst();
            if (!map.containsKey(temp)) continue;
            List<Integer> list = map.get(temp);
            for (Integer integer : list) {
                indeg[integer]--;
                if (indeg[integer]==0){
                    queue.addLast(integer);
                }
            }
        }
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i]>0) {
                return false;
            }
        }
        return true;
    }
}
