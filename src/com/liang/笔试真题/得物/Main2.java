package com.liang.笔试真题.得物;

import com.liang.utils.ListNode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.笔试真题.得物
 * @ClassName: Main2
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/10/1 15:44
 * @Version: 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ArrayList<ListNode> listNodes = new ArrayList<>();
        int i = 0;
        while (head!=null){
            if (i%k==0){
                listNodes.add(head);
            }
            head = head.next;
            i++;
        }
        ListNode tail = null;
        if (i%k!=0){
            tail = listNodes.remove(listNodes.size()-1);
        }
        for (int j = 0; j < listNodes.size(); j++) {
            ListNode listNode = reverseK(listNodes.get(j), k);
            listNodes.set(j, listNode);
        }
        listNodes.add(tail);
        for (int j = 0; j < listNodes.size()-1; j++) {
            ListNode listNode = listNodes.get(j);
            for (int l = 0; l < k-1; l++) {
                listNode = listNode.next;
            }
            listNode.next = listNodes.get(j+1);
        }
        return listNodes.get(0);
    }
    public ListNode reverseK(ListNode head, int k){
        ListNode now = head;
        ListNode next;
        ListNode pre = null;
        for (int i = 0; i < k; i++) {
            next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}
