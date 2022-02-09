package com.liang.剑指OfferII.哈希表;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.哈希表
 * @ClassName: M035最小时间差
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/9 22:57
 * @Version: 1.0
 */
public class M035最小时间差 {

    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] split = timePoints.get(i).split(":");
            times[i] = 60*Integer.parseInt(split[0])+Integer.parseInt(split[1]);
        }
        Arrays.sort(times);
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < times.length-1; i++) {
            minTime = Math.min(times[i+1]-times[i], minTime);
            if (minTime==0) return 0;
        }
        minTime = Math.min(24*60+times[0]-times[times.length-1], minTime);
        return minTime;
    }
}
