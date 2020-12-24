package com.offer.class_01;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class C23_BSTPostSub {

    public static class ReturnInfo {
        boolean isBST;
        int max;
        int min;

        public ReturnInfo(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }


    public static void VerifySquenceOfBST(int [] arr) {

    }

    public static ReturnInfo isBST(int [] arr, int start, int end){
        if(end == start){
            return new ReturnInfo(true, arr[end], arr[end]);
        }
        int root = arr[end];
        // not exist left
        if(arr[start] > root){
            ReturnInfo right = isBST(arr, start, end - 1);
            return new ReturnInfo(root < right.min && right.isBST, right.max, root);
        }
        // not exist right
        if(arr[end - 1] < root){
            ReturnInfo left = isBST(arr, start, end - 1);
            return new ReturnInfo(root > left.max && left.isBST, root, left.min);
        }

        int l = 0; int r = end - 1;
        while(l < r && r - l != 1){
            int mid = l + (r -l)/2;
            if(arr[mid] > root){
                r = mid;
            }else{
                l = mid;
            }
        }

        int mid = 0;
        ReturnInfo left = isBST(arr, start, l);
        ReturnInfo right = isBST(arr, r, end - 1);
        return new ReturnInfo(
                left.isBST && right.isBST && root > left.max && root < right.min,
                Math.max(left.max, right.max),
                Math.min(left.min, right.min
        ));
    }

}
