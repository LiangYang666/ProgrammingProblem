package com.liang.offer;

import java.util.ArrayList;
import java.util.Vector;
import com.liang.utils.TreeNode;

public class MOffer26树的子结构 {
//    public static ArrayList<Integer> elements = new ArrayList<>
    static
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null) return false;
        return dp(A, B);
    }
    static boolean dp(TreeNode A, TreeNode B){
        if(isSon(A, B)) return true;
        if(A!=null) {
            return dp(A.left, B) || dp(A.right, B);
        }
        return false;

    }
    static boolean isSon(TreeNode a, TreeNode b){
        if(b==null) return true;
        if(a==null) return false;
        if(a.val!=b.val){
            return false;
        } else {
            return isSon(a.left, b.left) && isSon(a.right, b.right);
        }

    }
}
