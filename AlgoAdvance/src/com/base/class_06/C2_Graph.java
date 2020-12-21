package com.base.class_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.base.class_06.Code_05_Kruskal.UnionFind;

public class C2_Graph {
    
    public static class Edge{
        int weight;
        Node from;
        Node to;
        public Edge(int weight, Node from, Node to) {
            super();
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }
    
    public static class Node {
        public int data;
        public int in;
        public int out;
        public List<Node> nexts;
        public List<Edge> edges;
        
        public Node(int data) {
            this.data = data;
            this.in = 0;
            this.out = 0;
            this.nexts = new ArrayList<Node>();
            this.edges = new ArrayList<Edge>();
        }
    }
    
    public static class Graph{
        HashMap<Integer, Node> nodes;
        HashSet<Edge> edges;
        public Graph() {
            super();
            this.nodes = new HashMap<>();
            this.edges = new HashSet<>();
        } 
        
    }
    
    public static void depth(Node node) {
        HashSet<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        System.out.println(node.data);
        set.add(node);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            for(Node no : cur.nexts) {
                if(!set.contains(no)) {
                    System.out.println(node.data);
                    stack.push(cur);
                    stack.push(no);
                    set.add(no);
                    break;
                }
            }
        }
    }
    
    public static void bredth(Node node) {
        HashSet<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        System.out.println(node.data);
        queue.add(node);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(Node no : cur.nexts) {
                if(!set.contains(no)) {
                    System.out.println(node.data);
                    queue.add(no);
                    set.add(no);
                }
            }
        }
    }
    
    public static List<Node> topo(Graph graph) {
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Integer> inMap = new HashMap<>();
        for(Node node : graph.nodes.values()) {
            if(node.in == 0) {
               queue.add(node);
               list.add(node); 
            }
            inMap.put(node, node.in);
        }
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if(inMap.get(next) == 0) {
                    queue.add(next);
                    list.add(next); 
                }
            }
        }
        return list;
    }
    
    public static Set<Edge> prim(Graph graph){
        HashSet<Node> nodeSet = new HashSet<>();
        HashSet<Edge> edgeSet = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for(Node node : graph.nodes.values()) {
            if(!nodeSet.contains(node)) {
                nodeSet.add(node);
                for(Edge edge : node.edges) {
                    queue.add(edge);
                }
                while(!queue.isEmpty()) {
                    Edge edge = queue.poll();
                    Node toNode = edge.to;
                    if(nodeSet.contains(toNode)) {
                        edgeSet.add(edge);
                        nodeSet.add(node);
                    }
                    for(Edge ed : toNode.edges) {
                        queue.add(edge);
                    }
                }
            }
        }
        return edgeSet;
    }
    
    public static Set<Edge> kruskal(Graph graph){
        HashSet<Edge> edgeSet = new HashSet<>();
        UnionFind unionFind = new UnionFind();
        return edgeSet;
    }

}
