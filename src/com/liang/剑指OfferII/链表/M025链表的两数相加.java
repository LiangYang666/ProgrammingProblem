package com.liang.剑指OfferII.链表;

import com.liang.utils.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.链表
 * @ClassName: M025链表的两数相加
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2021/12/23 12:40
 * @Version: 1.0
 */
public class M025链表的两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] a = new int[101];
        int[] b = new int[101];
        int[] rs = new int[101];
        int i=1;
        int j=1;
        while (l1!=null || l2!=null){
            if (l1!=null){
                a[i++] = l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                b[j++] = l2.val;
                l2 = l2.next;
            }
        }
        int k = Math.max(i, j)-1;
        int n = k;
        int c = 0;
        i--;
        j--;
        while (true){
            rs[k--] = (a[i]+b[j]+c)%10;
            c = (a[i]+b[j]+c)/10;
            if (i==0 && j==0)   break;
            if (i>0)    i--;
            if (j>0)    j--;
        }
        System.out.println(Arrays.toString(rs));
        int l =0;
        if (rs[0]==0)   l=1;
        ListNode rsDummy = new ListNode(0);
        ListNode node = rsDummy;
        for (; l <= n; l++) {
            node.next = new ListNode(rs[l]);
            node = node.next;
        }
        return rsDummy.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // ArrayDeque<Integer> a = new ArrayDeque<>(100);   //两种均可以
        // ArrayDeque<Integer> b = new ArrayDeque<>(100);
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();
        while (l1!=null){
            a.addLast(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            b.addLast(l2.val);
            l2 = l2.next;
        }
        int c = 0;
        ListNode now = new ListNode(0);
        while (!(c==0 && a.isEmpty()&&b.isEmpty())){
            int sum = c;
            sum+= a.isEmpty()?0:a.removeLast();
            sum+= b.isEmpty()?0:b.removeLast();
            now.val = sum%10;
            c = sum/10;
            ListNode node = new ListNode(0);
            node.next = now;
            now = node;
        }
        return now.next;
    }
}
