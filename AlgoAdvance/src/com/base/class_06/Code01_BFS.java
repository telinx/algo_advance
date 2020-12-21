package com.base.class_06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code01_BFS {
    
    public static void breadthTraversal(Node node) {
        if(node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        System.out.println(node.value);
        set.add(node);
        queue.add(node);
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(Node next: cur.nexts) {
                if(!set.contains(next)) {
                    System.out.println(next.value);
                    set.add(next);
                    queue.add(next);
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
        Code01_BFS.breadthTraversal(graph.nodes.get(0));
    }

}
