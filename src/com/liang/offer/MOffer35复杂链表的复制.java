package com.liang.offer;

import com.liang.utils.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class MOffer35复杂链表的复制 {
    public Node copyRandomList(Node head) {
        Node temp1 = head;
        Node temp2 = null;
        Node dump = new Node(0);
        Node last = dump;
        HashMap<Node, Integer> nodes1Map = new HashMap<>();
        ArrayList<Node> nodes2 = new ArrayList<>();
        for (int i = 0; temp1!=null; i++) {
            temp2 = new Node(temp1.val);
            nodes1Map.put(temp1, i);
            nodes2.add(temp2);
            last.next = temp2;
            last = temp2;
            temp1 = temp1.next;
            temp2 = temp2.next;

        }
        nodes1Map.put(null, nodes2.size());
        nodes2.add(null);
        temp1 = head;
        temp2 = dump.next;
        while (temp1!=null){
            int id = nodes1Map.get(temp1.random);
            temp2.random = nodes2.get(id);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return dump.next;
    }
}
