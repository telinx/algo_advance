package com.advence.class_03;
/**
 * 定义一个遍历指针cur，该指针首先指向头结点
 * 判断cur的左子树是否存在
 *  如果cur的左孩子为空，说明cur的左子树不存在，那么cur右移来到cur.right
 *  如果cur的左孩子不为空，说明cur的左子树存在，找出该左子树的最右结点，记为mostRight
 *    如果mostRight.right == null，那就让其指向cur（mostRight.right=cur），并左移cur（cur=cur.left）
 *    如果mostRight.right != null，那么让cur右移（cur=cur.right），并将mostRight的右孩子置空
 * @author yucang
 *
 */
public class Morris {
    public static class Node {
        public Integer value;
        public Node left;
        public Node right;
        
        public Node(Integer value) {
            this.value = value;
        }
    }
    public static void preMorris(Node header) {
        Node cur = header;
        while(cur != null) {
           if(cur.left != null) {
               Node mostRight = cur.left;
               while(mostRight.right != null && mostRight.right != cur) {
                   mostRight = mostRight.right;
               }
               if(mostRight.right == null) {
                   System.out.println(cur.value);
                   mostRight.right = cur;
                   cur = cur.left;
               }else {
                   mostRight = null;
                   cur = cur.right;
               }
           }else {
               System.out.println(cur.value);
               cur = cur.right;
           }
        }
    }
    
    public static void inMorris(Node header) {
        Node cur = header;
        while(cur != null) {
           if(cur.left != null) {
               Node mostRight = cur.left;
               while(mostRight.right != null && mostRight.right != cur) {
                   mostRight = cur.right;
               }
               if(mostRight.right == null) {
                   mostRight.right = cur;
                   cur = cur.left;
               }else {
                   System.out.println(cur.value);
                   mostRight = null;
                   cur = cur.right;
               }
           }else {
               System.out.println(cur.value);
               cur = cur.right;
           }
        }
    }

}
