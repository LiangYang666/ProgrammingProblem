package com.liang.笔试真题.网易.秋招.zhj;

import java.util.*;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.笔试真题.网易.秋招.zhj
 * @ClassName: Main4
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/8/20 15:07
 * @Version: 1.0
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (!map.containsKey(a[i])){
                map.put(a[i], new ArrayList<>());
            }
            map.get(a[i]).add(i);
        }
        int rs = 0;
        for (Integer key : map.keySet()) {
            List<Integer> indexes = map.get(key);
            if (indexes.size()==1)  continue;
            int[] tempTotal = new int[indexes.size() - 1];
            for (int i = 1; i < indexes.size(); i++) {
                int tt = 0;
                for (int j = indexes.get(i-1); j < indexes.get(i); j++) {
                    if (a[j]<key){
                        tt++;
                    }
                }
                tempTotal[i-1] = tt;
            }
            int tempN = tempTotal.length;
            for (int i = 0; i < tempN; i++) {
                int temp = 0;
                for (int j = i; j < tempN; j++) {
                    temp+=tempTotal[j];
                    rs+=temp;
                }
            }
        }
        System.out.println(rs);
    }
}
