package com.liang.normal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/*
210. 课程表 II
现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。

例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。

输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
输出：[0,2,1,3]
解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
示例 3：

输入：numCourses = 1, prerequisites = []
输出：[0]
 */

public class MIndex210课程表II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses<0)    return new int[0];
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        //计算每个节点的入度  入度表
        for (int[] each: prerequisites){
            inDegree.putIfAbsent(each[0], 0);
            inDegree.putIfAbsent(each[1], 0);
            inDegree.put(each[0], inDegree.get(each[0])+1);     //可优化？
        }
//        numCourses = inDegree.keySet().size();
        LinkedList<Integer> queue = new LinkedList<>();
        for (Integer key :
                inDegree.keySet()) {
            if(inDegree.get(key)==0){
                queue.add(key);
            }
        }
        int count = 0;
        int[] rs = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(!inDegree.containsKey(i)){
                rs[count++] = i;
            }
        }
        while(!queue.isEmpty()){
            Integer now  = queue.poll();
            rs[count++] = now;
            for(int[] each: prerequisites){
                if(each[1]==now){
                    int next = each[0];
                    inDegree.put(next, inDegree.get(next)-1);
                    if(inDegree.get(next)==0){
                        queue.add(next);
                    }
                }
            }
        }
        if (count==numCourses){
            return rs;
        } else {
            return new int[0];
        }
    }
}
