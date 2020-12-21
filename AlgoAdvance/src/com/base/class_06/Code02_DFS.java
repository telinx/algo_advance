package com.base.class_06;

import java.util.HashSet;
import java.util.Stack;

public class Code02_DFS {
    
    public static void DepthTraversal(Node node) {
        if(node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        System.out.println(node.value);
        set.add(node);
        stack.push(node);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            for(Node next : cur.nexts) {
                if(!set.contains(next)) {
                    System.out.println(next.value);
                    set.add(next);
                    stack.push(cur);
                    stack.push(next);
                    break;
                }
            }
        }
        
        
    }
    
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][] {
            {3, 0, 2},
            {4 ,1, 2},
            {2, 2, 3},
            {6, 2, 4},
            {1, 3, 5},
            {1, 4, 6},
        };
        Graph graph = GraphGenerator.createGraph(matrix, false);
        Code02_DFS.DepthTraversal(graph.nodes.get(0));
    }

}
