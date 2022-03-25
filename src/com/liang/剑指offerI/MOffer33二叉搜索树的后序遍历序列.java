package com.liang.剑指offerI;

public class MOffer33二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        int[] a = {5, 2, -17, -11, 25, 76, 62, 98, 92, 61};
        System.out.println(verifyPostorder(a));
    }
    static
    public boolean verifyPostorder(int[] postorder) {
        return dp(postorder, 0, postorder.length-1);
    }
    static
    public boolean dp(int[] postorder, int i, int j) {
        System.out.println(i+" "+j);
        if(i>=j) return true;
        int root_val = postorder[j];
        int m;
        for (m=0; m < j; m++) {
            if(root_val<postorder[m])   break;
        }
        for (int k = m; k < j; k++) {
            if(root_val>postorder[k])   return false;
        }
        System.out.println(i+" "+m+" "+" "+j);
        return (dp(postorder, i, m-1) && dp(postorder, m, j-1));
    }

}
