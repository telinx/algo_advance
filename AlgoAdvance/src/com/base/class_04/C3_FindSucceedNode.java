package com.base.class_04;

/**
 * 在二叉树中找到中序遍历的后继节点 1 2 3 ，2的后继是3 前驱是1
 * 分两种情况
 * 1.cur有右子树，后继为右子树的左子树（假设有）
 * 2.cur没有右子树
 *  2.1 cur是父节点的左子树 后继为parent
 *  2.2 cur是父节点的右子树 后继为
 *          cur.parent.parent != null &&  cur.parent.parent.left = cur.parent.parent
 * 
 *  一直传递上去
 *  
 * 问题扩展：
 * 找前驱
 * 1.有左子树
 * 2.没有有左子树
 *  2.1 cur是parent的右子树，前驱是parent
 *  2.1 cur是parent的右子树,一直网上找
 *      cur.parent.parent != null &&  cur.parent.parent.right = cur.parent.parent
 * @author yucang
 *
 */
public class C3_FindSucceedNode {
    public static class Node { 
        public int value; 
        public Node left;
        public Node right; 
        public Node parent;
        
        public Node(int data) { 
            this.value = data; 
        }
        
        public Node(int data, Node parent) { 
            this.value = data; 
        }
        
    } 
    
    
    public static Node findSucceedNode(Node cur) {
        Node succeed = null;
        if(cur.right != null) {
            succeed = cur.right;
            while(succeed.left != null) {
                succeed = succeed.left;
            }
            return succeed;
        }else {
            Node parent = cur.parent;
            while(parent != null && parent.left != cur) {
                cur = parent;
                parent = cur.parent;
            }
            return parent;
        }
    }
    
}
