package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试常考算法题.codeTop
 * @ClassName: T9合并两个有序链表
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/7/7 8:48
 * @Version: 1.0
 */
public class T9合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dumpHead = new ListNode(-1);
        ListNode last = dumpHead;
        while (list1 != null && list2 != null) {
            if (list1.val<=list2.val){
                last.next = list1;
                list1 = list1.next;
            } else {
                last.next = list2;
                list2 = list2.next;
            }
            last = last.next;
        }
        if (list1!=null){
            last.next = list1;
        } else {
            last.next = list2;
        }
        return dumpHead.next;
    }
}
