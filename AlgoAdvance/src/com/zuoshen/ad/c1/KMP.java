package com.zuoshen.ad.c1;

///**
// *   -1 0 0 0 1 2 0
// *    A B C A B X Y
// *    0 1 2 3 4 5 6
// */
//public class KMP {
//
//    public static int[] next(char[] target) {
//        int[] next = new int[target.length];
//        next[0] = -1;
//        next[1] = 0;
//        for(int j = 2; j < target.length; j++){
//            int k = target[j-1];
//            while(k != -1){
//                if(target[j-1] == target[k]){
//                    next[j] = k + 1;
//                    break;
//                }else{
//                    k = next[k];
//                }
//                next[j] = 0;
//            }
//        }
//
//        return next;
//    }
//
//}
