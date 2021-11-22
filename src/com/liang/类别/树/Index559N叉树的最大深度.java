package com.liang.类别.树;

import java.util.List;

public class Index559N叉树的最大深度 {
    public int maxDepth(Node root) {       // 深度优先搜索
        if(root==null)  return 0;
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(maxDepth(root.children.get(i)), max);
        }
        return max+1;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
