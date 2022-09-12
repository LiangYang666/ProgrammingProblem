package com.liang.笔试真题.网易.雷火诚哥;

import java.util.Arrays;

public class Main1 {
    static int ans;
    static int n;
    static int[] cab;

    public static void main(String[] args) {

        int[] productList = {5,5,6,6,10,10, 10};
        int[][] drivingTimes ={{0,1,5}, {1, 0, 2}, {5, 1,0}};
        Main1 main1 = new Main1();
        System.out.println(main1.getMinimumTime(productList, drivingTimes));

    }
    public int getMinimumTime(int[] productList, int[][] drivingTimes){
        cab = new int[productList.length];
        ans = productList.length;
        n = ans;
        int time = dfs(drivingTimes, 0, 0, new boolean[drivingTimes.length]);
        productList = Arrays.stream(productList).boxed().sorted((a, b) -> b - a).mapToInt(p -> p).toArray();
        dfsGetCar(0, 0, productList);
        System.out.println(time);
        System.out.println(ans);
        if (ans/4==0)   return time;
        return time*((ans/4)*2+1);
    }
//    static
    public int dfs(int[][] drivingTimes, int cur, int times, boolean[] visited){
        int n = visited.length;
        if (cur==n-1){
            return times;
        }
        int nowMinLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            int minAfterLength = dfs(drivingTimes, i, times+drivingTimes[cur][i], visited);
            nowMinLength = Math.min(nowMinLength, minAfterLength);
            visited[i] = false;
        }
        return nowMinLength;
    }

    public void dfsGetCar(int now, int cnt, int[] productList){
        if(cnt>ans) return;
        if (now==n){
            ans = Math.min(ans, cnt);
            return;
        }
        for (int i = 0; i < cnt; i++) {
            if (productList[now]+cab[i]<=10){
                cab[i]+=productList[now];
                dfsGetCar(now+1, cnt, productList);
                cab[i] -= productList[now];
            }
        }
        cab[cnt] = productList[now];
        dfsGetCar(now+1, cnt+1, productList);
        cab[cnt] = 0;
    }
}
