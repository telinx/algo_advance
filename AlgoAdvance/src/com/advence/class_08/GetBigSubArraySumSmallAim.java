package com.advence.class_08;

/**
 * https://juejin.cn/post/6844903779289006093#heading-26
 * 求和小于等于aim的最长子数组（有正有负有0）
 * 核心思想 只关心最长的答案，LR只往前走
 * 借助了辅助空间，利用已求历史结果加速
 * @author yucang
 *
 */
public class GetBigSubArraySumSmallAim {
    
    public static int getBigSubArraySumSmallAim(int[] arr, int aim) {
        // i开头的所有子数组的最小累加值
        int[] min_sum = new int[arr.length];
        // i开头的所有子数组的最小累加值的右边界
        int[] min_sum_index = new int[arr.length]; 
        
        int length = arr.length;
        min_sum[length - 1] = arr[length - 1];
        min_sum_index[length - 1] = length - 1;
        for(int i = length - 2; i >= 0; i++) {
            if(min_sum[i + 1] < 0) {
                min_sum[i] = arr[i] + arr[i + 1];
                min_sum_index[i] = i + 1;
            }else {
                min_sum[i] = arr[i];
                min_sum_index[i] = i;
            }
        }
        int R = 0;
        int sum = 0;
        int len = 0;
        for(int L = 0; L < length; L++) {
            while(R < length && sum + min_sum[R] < aim) {
                sum += min_sum[R];
                R = min_sum_index[R] + 1;
            }
            len = Math.max(len, R - L);
            sum -= R==L ? 0: arr[L];
            R = Math.max(R, L + 1);  // 右边界不回退
        }
        return len;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 1, 1, 1, 1, 1, 1, 9};
        System.out.println(getBigSubArraySumSmallAim(arr, 6));
        
    }
    

}
