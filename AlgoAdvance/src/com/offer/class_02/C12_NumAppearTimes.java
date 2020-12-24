package com.offer.class_02;
/**
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 * @author yucang
 *
 */
public class C12_NumAppearTimes {
    public int GetNumberOfK(int [] arr , int k) {
        int start, end, left, right;
        for(start = -1, end = arr.length - 1; end > start && end- start != -1;) {
            int mid = start + (end -start)/2;
            if(arr[mid] >= k) {
                end = mid;
            }else {
                start = mid;
            }
        }
        left = end;
        for(start = -1, end = arr.length; end > start && end - start != 1 ;){
            int mid = start + ((end - start) >> 1);
            if(arr[mid] > k){
                end = mid;
            }else{
                start = mid;
            }
        }
        right = start;

        return right - left + 1;
    }
}
