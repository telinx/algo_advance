package com.base.class_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code_03_TopoSort {

    public static List<Node> topoSort(Graph graph){
        Queue<Node> queue = new LinkedList<Node>();
        List<Node> result = new ArrayList<>();
        HashMap<Node, Integer> inMap = new HashMap<>();
        for(Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if(node.in == 0) {
                queue.add(node);
            }
        }
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            result.add(cur);
            for(Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
//                inMap.put(next, next.in - 1);
                if(inMap.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][] {
            {0, 1, 2},
            {0, 2 ,4},
            {0, 1, 3},
            {0, 3 ,4},
            {0, 5, 3},
            {0, 3, 6}
        };
        Graph graph = GraphGenerator.createGraph(matrix, true);
        List<Node> topo = topoSort(graph);
        for(Node node : topo) {
            System.out.print(node.value + "\t");
        }
    }
    
}
