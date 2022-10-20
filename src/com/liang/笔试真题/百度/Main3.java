package com.liang.笔试真题.百度;

import java.util.*;

public class Main3 {
    static long[] a;
    static long[] rs;
    static HashMap<Integer, List<Integer>> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        a = new long[n+1];
        rs = new long[n+1];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i+1] = sc.nextLong();
            a[i+1] = getMin(a[i+1]);
        }
        for (int i = 0; i < n - 1; i++) {
            int ut = sc.nextInt();
            int vt = sc.nextInt();
            int u = Math.min(ut, vt);
            int v = Math.max(ut, vt);
            if (!map.containsKey(u)){
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            dfsMultipy(x, y);
        }
//        System.out.println(Arrays.toString(a));
        dfsGet(1);
//        System.out.println(Arrays.toString(rs));
        for (int i = 1; i < n; i++) {
            System.out.print(check0(rs[i])+" ");
        }
        System.out.println(check0(rs[n]));
    }
    public static int check0(long num){
        int rs = 0;
        if (num==0) return 0;
        while (num%10==0 && num/10>0){
            rs++;
            num/=10;
        }
        return rs;
    }
    public static void dfsMultipy(int x, int y){
        if (y%2!=0 && y%5!=0)   return;
        y = (int) getMin(y);
        a[x] = a[x]*y;
        if (!map.containsKey(x)) return;
        List<Integer> list = map.get(x);
        for (int i = 0; i < list.size() ; i++) {
            dfsMultipy(list.get(i), y);
        }
    }
    public static long getMin(long x){
        return x/getDivideNum(x);
    }
    public static long getDivideNum(long x){
        while (true){
            if (x%2==0){
                x/=2;
            } else if (x%5==0){
                x/=5;
            } else {
                break;
            }
        }
        return x;

    }
    public static long dfsGet(int i){
        long temp = a[i];
        if (map.containsKey(i)){
            List<Integer> list = map.get(i);
            for (int j = 0; j < list.size(); j++) {
                temp *= dfsGet(list.get(j));
                temp = getMin(temp);
            }
        }
        rs[i] = temp;
        return temp;
    }
}
