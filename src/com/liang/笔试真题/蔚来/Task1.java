package com.liang.笔试真题.蔚来;

import java.util.ArrayList;
import java.util.Scanner;

/*
假设c是x，y的最大公约数。那么x和y都是c的倍数，x与y的差也是c的倍数，
所以通过一系列相减能够得到数都是c的倍数。池中的这些数都大于等于c，
是c的倍数，因此相减操作不会出现比c更小的数。
用大的数除下公约数，个数为偶数，则B赢 奇数个则A赢，因为A先开始
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(sc.nextInt());
            temp.add(sc.nextInt());
            arr.add(temp);
        }
        for (int i = 0; i < T; i++) {
            func(arr.get(i).get(0), arr.get(i).get(1));
        }
    }
    static
    public int isASheng(int m, int n){//
        if (n==0) return m;
        return isASheng(n, m%n);
    }
    static
    public void func(int m, int n){
        int res = isASheng(m, n);
        int max = Math.max(m / res, n / res);
        if ((max&1)!=0){
            System.out.println("A");
        }else {
            System.out.println("B");
        }
    }

}
