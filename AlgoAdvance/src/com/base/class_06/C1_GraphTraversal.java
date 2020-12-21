package com.base.class_06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 代码要素
 * 顶点vertex
 * 邻接矩阵matrix
 * 前序遍历  深度遍历
 * 层度遍历  广度遍历
 * @author yucang
 *
 */

public class C1_GraphTraversal {
    
    public static class Vertex{
        public char txt;
        public boolean isVisited;
        
        public Vertex(char txt) {
            this.txt = txt;
        }
    }
    
    private List<Vertex> vertexs;
    
    private int[][] matrix;
    
    private int size;
    
    private int index;
    
    public C1_GraphTraversal(int size) {
        this.vertexs = new ArrayList<Vertex>();
        this.index = 0;
        matrix = new int[size][size];
    }
    
    public void addVertex(char txt) {
        if(index >= size) {
            return;
        }
        this.index++;
        this.vertexs.add(new Vertex(txt));
    }
    
    public void addEdges(int start, int end) {
        if(start < 0 || start >= this.vertexs.size() || end < 0 || end >= this.vertexs.size()) {
            this.matrix[start][end] = 1;
            this.matrix[end][start] = 1;
        }
    }
    
    public void depthTraversal() {
        if(this.vertexs.size() < 1) {
           return; 
        }
        Stack<Integer> stack = new Stack<>();
        this.vertexs.get(0).isVisited = true;
        System.out.print(this.vertexs.get(0).txt + "\t");
        stack.add(0);
        while(!this.vertexs.isEmpty()) {
            int i = getUnvisitedNode(stack.peek());
            if(i == -1) {
                stack.pop();
            }else {
                this.vertexs.get(i).isVisited = true;
                System.out.print(this.vertexs.get(i).txt + "\t");
                stack.push(i);
            }
        }
        for(Vertex v : this.vertexs) {
            v.isVisited = false;
        }
    }
    
    public void bredthTraversal() {
        Queue<Integer> queue = new LinkedList<Integer>();
        this.vertexs.get(0).isVisited = true;
        System.out.print(this.vertexs.get(0).txt + "\t");
        queue.add(0);
        while(!queue.isEmpty()) {
            while(true) {
                int i = getUnvisitedNode(queue.poll());
                if(i == -1) {
                    break;
                }
                this.vertexs.get(i).isVisited = true;
                System.out.print(this.vertexs.get(i).txt + "\t");
                queue.add(i);
            }
            queue.poll();
        }
        for(Vertex v : this.vertexs) {
            v.isVisited = false;
        }
    }
    
    public int getUnvisitedNode(int v) {
        for(int i = 0; i < this.vertexs.size(); i++) {
            if(matrix[v][i] == 1 && !this.vertexs.get(i).isVisited) {
                return i;
            }
        }
        return -1;
    }

}
