package com.base.class_07;
/**
 * 前缀树的应用
 * 前缀   匹配
 * 字符串 检索
 * 词频   统计
 * 字符串  排序
 * 
 * 
 * 前缀树的root = new TrieNode
 * 
 * 空间换时间
 * 核心
 * 定义出Node，
 *  关键变量 
 *      路过数，
 *      终止数，
 *      子节点数组（26个英文字母）
 *  int path
 *  int end
 *  Trie[] next
 * @author yucang
 *
 */
public class C1_TrieTree {
    
    private TrieNode root = new TrieNode();

    public static class TrieNode{
        int path;
        int end;
        TrieNode[] next;
        
        public TrieNode() {
            this.path =0;
            this.end = 0;
            this.next = new TrieNode[26];
        }
    }
    
    public void add(String word) {
        if(word == null || word.length() < 1) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode tempNode = root;
        for(char c : chars) {
            int idx = c - 'a';
            if(tempNode.next[idx] == null) {
                tempNode.next[idx] = new TrieNode();
            }
            tempNode.next[idx].path++;
            tempNode = tempNode.next[idx];
        }
        tempNode.end++;
    }
    
    public int getEnd(String word) {
        if(word == null || word.length() < 1) {
            return 0;
        }
        char[] chars = word.toCharArray();
        TrieNode tempNode = root;
        for(char c : chars) {
            int idx = c - 'a';
            if(tempNode.next[idx] == null) {
                return 0;
            }
            tempNode = tempNode.next[idx];
        }
        return tempNode.end;
    }
    
    public int getPre(String word) {
        if(word == null || word.length() < 1) {
            return 0;
        }
        char[] chars = word.toCharArray();
        TrieNode tempNode = root;
        for(char c : chars) {
            int idx = c - 'a';
            if(tempNode.next[idx] == null) {
                return 0;
            }
            tempNode = tempNode.next[idx];
        }
        return tempNode.path;
    }
    
    
}
