package com.liang.笔试真题.网易.秋招.lc;

import java.util.*;

public class Main4 {
    static HashMap<Integer, ArrayList<Long>> map;
    static int[] a;
    static ArrayList<Long> allFactors;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i+1] = sc.nextInt();
        }
        map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            long v = sc.nextLong();
            if (!map.containsKey(u)){
                ArrayList<Long> temp = new ArrayList<>();
                temp.add((long) -1);
                map.put(u, temp);
            }
            ArrayList<Long> l = map.get(u);
            l.add(v);
        }
        dfs(1);
//        for (int i = 1; i < n+1; i++) {
//            System.out.println(map.get(i).get(0));
//        }
        allFactors = getAllFactors(map.get(1).get(0));
        allFactors.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (o1<o2) return -1;
                else if (o1.equals(o2))   return 0;
                return 1;
            }
        });
//        System.out.println(Collections.unmodifiableList(allFactors));
        long rs = allFactors.size();
        for (int i = 2; i < n+1; i++) {
            rs = rs%1000000007+getFactorTotal(map.get(i).get(0));
        }
        System.out.println(rs);
    }
    static ArrayList<Long> getAllFactors(long n){
        ArrayList<Long> l = new ArrayList<>();
        if (n == 0)
            return l;
        else {
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    l.add((long) i);
                    l.add(n/i);
                }
            }
            return l;
        }
    }
    static long getFactorTotal(long n){
        long count = 0;
        for (int i = 0; i < allFactors.size(); i++) {
            long temp = allFactors.get(i);
            if (temp<=n && n%temp==0){
                count++;
            }
        }
        return count;
    }
    static long dfs(int point){
        if (!map.containsKey(point)){
            ArrayList<Long> tt = new ArrayList<>();
            tt.add((long) a[point]);
            map.put(point, tt);
        }
        ArrayList<Long> list = map.get(point);
        if (list.get(0)!=-1){
            return list.get(0);
        }
        long tempMul = a[point];
        for (int i = 1; i < list.size(); i++) {
            tempMul*=dfs((int)(long)list.get(i));
        }
        list.set(0, tempMul);
        return list.get(0);
    }

}
