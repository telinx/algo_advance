package com.offer.class_02;

import java.util.ArrayList;

/**
 * 最小的k个数
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8
 * 这8个数字，则最小的4个数字是1,2,3,4,。
 * 还可以考虑使用另一种数据结构，最大堆，用最大堆保存这k个数，每次只和堆顶比，
 * 如果比堆顶小，删除堆顶，新数入堆。
 *
 * https://www.cnblogs.com/zzmher/p/7730700.html
 * @author yucang
 *
 */
public class C4_ArrLessKValue {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(k<=0){
            return result;
        }
        if(input.length==0||input.length<k){
            return result;
        }
        int start=0;
        int end=input.length-1;
        int index=Partition(input,start,end);
        while(index!=k-1){
            if(index>k-1){
                end=index-1;
                index=Partition(input,start,end);
            }else{
                start=index+1;
                index=Partition(input,start,end);
            }
        }
        for(int i=0;i<k;i++){
            result.add(input[i]);
        }
        return result;
    }
    public int Partition(int[] input,int start,int end){
        int pivot=input[start];
        while(start<end){
            while(start<end&&input[end]>=pivot){--end;}
            input[start]=input[end];
            while(start<end&&input[start]<=pivot){++start;}
            input[end]=input[start];
        }
        input[end]=pivot;
        return end;
    }
}
