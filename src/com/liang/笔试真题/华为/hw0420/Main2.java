package com.liang.笔试真题.华为.hw0420;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/20 下午8:06
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        String[] all = s1.substring(1, s1.length() - 1).split(",");
        String[] pos = s2.substring(1).split("/");
        String[] want = s3.substring(1, s3.length() - 1).split(",");
        int index = 0;
        for (int i = 0; i < all.length; i++) {
            if (pos[0].equals(all[i])){
                int temp = 2*i+1;
                if (pos[1].equals(all[temp])) {
                    index=temp;
                    break;
                }
                else if (pos[1].equals(all[++temp])) {
                    index=temp;
                    break;
                }
            }
        }
        all[index] = want[0];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(index);
        for (int i = 1; i < want.length; i+=2) {
            int temp = queue.removeFirst();
            temp = temp*2+1;
            all[temp] = want[i];
            all[temp+1] = want[i+1];
            queue.addLast(temp);
            queue.addLast(temp+1);
        }
        System.out.print("[");
        for (int i = 0; i < all.length; i++) {
            if (!all[i].equals("0")){
                if (i!=0) System.out.print(",");
                System.out.print(all[i]);
            }
        }
        System.out.print("]");
    }
}
