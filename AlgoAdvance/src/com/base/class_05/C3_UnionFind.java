package com.base.class_05;

/**
 * 并查集
 * parent数组和weight数组
 * 查是是否是同一个老大，帮派合并
 */
public class C3_UnionFind {

    private int size;

    private int[] parent;

    private int[] weight;

    private int groups;

    public C3_UnionFind(int size){
        this.size = size;
        this.groups = size;
        this.parent = new int[size];
        this.weight = new int[size];
        for(int i = 0; i < size; i++){
            this.parent[i] = i;
            this.weight[i] = i;
        }
    }

    public int find(int element){
        while(element != parent[element]){
            this.parent[element] = this.parent[this.parent[element]];
            element = this.parent[element];
        }
        return element;
    }

    public boolean isConnected(int ele1, int ele2){
        return this.find(ele1) == this.find(ele2);
    }

    public void union(int ele1, int ele2){
        int ele1Parent = this.find(ele1);
        int ele2Parent = this.find(ele2);

        if(ele1Parent == ele2Parent){
            return;
        }

        if(weight[ele1Parent] > this.weight[ele2Parent]){
            parent[ele2Parent] = ele1Parent;
            this.weight[ele1Parent] += this.weight[ele2Parent];
        }else{
            parent[ele1Parent] = ele2Parent;
            this.weight[ele2Parent] += this.weight[ele2Parent];
        }
        this.groups--;

    }

    public int getGroups(){
        return this.groups;
    }

}
