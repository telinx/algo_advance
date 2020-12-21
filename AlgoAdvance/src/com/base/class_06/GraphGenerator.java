package com.base.class_06;

public class GraphGenerator {

    /**
     * 
     * @param edgeMatrix edge矩阵
     * @param direct 有向无向
     * @return
     */
    public static Graph createGraph(Integer[][] edgeMatrix, boolean direct) {
        Graph graph = new Graph();
        for(int i = 0; i < edgeMatrix.length; i++) {
            Integer weight = edgeMatrix[i][0];
            int from = edgeMatrix[i][1];
            int to = edgeMatrix[i][2];
            if(!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if(!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            
            if(direct) {
                Edge newEdge1 = new Edge(weight, toNode, fromNode);
                toNode.nexts.add(fromNode);
                toNode.out++;
                fromNode.in++;
                toNode.edges.add(newEdge1);
                graph.edges.add(newEdge1);  
            }
            
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
