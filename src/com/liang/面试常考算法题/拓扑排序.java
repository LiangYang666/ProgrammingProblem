package com.liang.面试常考算法题;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.常考算法题
 * @ClassName: 拓扑排序
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/3/25 19:50
 * @Version: 1.0
 */
// 力扣 课程表 207
public class 拓扑排序 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> presChildren = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            presChildren.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] info = prerequisites[i];
            presChildren.get(info[1]).add(info[0]);
            degree[info[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i]==0){
                queue.addLast(i);
            }
        }
        int hasOk = 0;
        while (!queue.isEmpty()){
            Integer temp = queue.removeFirst();
            hasOk++;
            ArrayList<Integer> children = presChildren.get(temp);
            for (int i = 0; i < children.size(); i++) {
                if (0==--degree[children.get(i)]){
                    queue.addLast(children.get(i));
                }
            }
        }
        return hasOk==numCourses;
    }


}
