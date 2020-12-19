package com.base.class_08;
/**
 * 给定两个数组w和v,两个数组长度相等
 * ,w[i]表示第i件商品的重量,
 * ,v[i]表示第i件商品的价值。 
 * 再给定一个整数bag,要求你挑选商品的重量加起来一定不能超 过bag,
 * 返回满足这个条件下,你能获得的最大价值。
 * @author yucang
 *
 */
public class C10_knapsack {
    
    public static int getMaxValue(int[] w, int[] v, int bag, int i, int weight) {
        if(weight < bag) {
            return 0;
        }
        if(i == w.length) {
            return 0;
        }
        return Math.max(
            getMaxValue(w, v, bag, i+1, weight)
            , 
            v[i]+getMaxValue(w, v, bag, i+1, weight+v[i])
           );
    }
    
    

}
