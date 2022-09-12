package com.liang.笔试真题.字节.hu;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= 10; i++) {
            int t = (int) Math.pow(2, i);
            map.put(t, i);
//            System.out.println(t+":"+i);
        }
        map.put(0, 0);
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] pow = new int[n];
            int[] sum = new int[n+1];
            ArrayList<Integer> index = new ArrayList<>();
            index.add(-1);
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                pow[j] = map.get(arr[j]);
                sum[j+1] = sum[j]+pow[j];
                if (arr[j]==0){
                    index.add(j);
                }
            }
            index.add(n);
//            System.out.println(Collections.unmodifiableList(index));
//            System.out.println(Arrays.toString(sum));
            int max = Integer.MIN_VALUE;
            int st = 0;
            int ed = 0;
            for (int j = 0; j < index.size()-1; j++) {
                int start = index.get(j);
                int end = index.get(j+1);
                int temp = sum[end]-sum[start+1];
                if (temp>max){
//                    System.out.println(temp+" "+start+" "+end);
                    max = temp;
                    st = start+1+1;
                    ed = end-1+1;
                }
            }
            System.out.println(st+" "+ed);
        }

    }
}
