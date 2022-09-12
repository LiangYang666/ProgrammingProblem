package com.liang.剑指offerI;


public class MOffer36二叉搜索树与双向链表_递归做 {    //递归方法 每次dp返回该节点对应链表的的头和尾节点
    public Node treeToDoublyList(Node root) {
        if(root==null) return root;
        HeadTail rs = dp(root);
        rs.head.left = rs.tail;
        rs.tail.right = rs.head;

        return rs.head;
    }
    public HeadTail dp(Node root){
        HeadTail rs = new HeadTail(root, root);
        if(root.left!=null){
            HeadTail leftDp = dp(root.left);
            leftDp.tail.right = root;
            root.left = leftDp.tail;
            rs.head = leftDp.head;
        }
        if(root.right!=null){
            HeadTail rightDp = dp(root.right);
            root.right = rightDp.head;
            rightDp.head.left = root;
            rs.tail = rightDp.tail;
        }
        return rs;
    }

}

class HeadTail {
    public Node head;
    public Node tail;

    public HeadTail(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
}
class MOffer36二叉搜索树与双向链表_中序遍历 {    //中序遍历

    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }
    public void dfs(Node root){
        if(root==null)  return;
        dfs(root.left);
        if(pre==null){
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};