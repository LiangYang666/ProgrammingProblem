package com.liang.剑指offerI;

import java.util.Stack;

public class Offer31栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,1,2};
        System.out.println(validateStackSequences(pushed, popped));

    }
    static
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean[] visit = new boolean[pushed.length];
        int last=-1;
        for (int i = 0; i < pushed.length; i++) {
            if(popped[0]==pushed[i]){
                last = i;
                visit[i] = true;
                break;
            }
        }
        if(last ==-1) return false;
        for (int i = 1; i < popped.length; i++) {
            int n = popped[i];
            int now=-1;
            now=getLeftFirstNoVisit(visit, last);
            if(now>=0 && n==pushed[now]){
                last = now;
                visit[now] = true;
            } else {
                now = -1;
                for (int j = last; j < pushed.length; j++) {
                    if(pushed[j]==n){
                        now = j;
                    }
                }
                if(now>=0){
                    last = now;
                    visit[now] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    static
    public int getLeftFirstNoVisit(boolean[] visit, int last){
        for (int i = last; i >= 0; i--) {
            if(visit[i]==false){
                return i;
            }
        }
        return -1;
    }
}

class Offer31栈的压入弹出序列_辅助栈 {

    public static void main(String[] args) {
        int[] pushed = {};
        int[] popped = {};
        System.out.println(validateStackSequences(pushed, popped));

    }
    static
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stackAssist = new Stack<> ();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stackAssist.push(pushed[i]);
            while (j< popped.length && !stackAssist.isEmpty()){
                if(popped[j]==stackAssist.peek()){
                    stackAssist.pop();
                    j++;
                } else {
                    break;
                }
            }
        }
        if(j!=popped.length){
            return false;
        }
        return true;


    }



}
