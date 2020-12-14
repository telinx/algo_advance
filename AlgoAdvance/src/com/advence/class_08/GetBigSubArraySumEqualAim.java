package com.advence.class_08;

/**
 * 求和为aim的最长子数组
 * 思路：左右两个游标L R（都在-1位置），sum小于aim R扩，sum大于aim L扩，
 * 等于aim的记录且sum - arr[++L]
 * @author yucang
 *
 */
public class GetBigSubArraySumEqualAim {
    
    public static int getBigSubArraySumEqualAim(int[] arr, int aim) {
        // 去除非法
        // ...
        int L = -1,R = -1;
        int sum = 0;
        int len = 0;
        while(R <= arr.length) {
            if(sum < aim) {
                R++;
                if(R < arr.length) {
                    sum += arr[R];
                }else {
                    break;
                }
            }else if(sum == aim){
                len = Math.max(len, R - L);
                sum -= arr[++L];
            }else {
                sum -= arr[++L];
            }
        }
        return len;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 1, 1, 1, 1, 1, 1, 9};
        System.out.println(getBigSubArraySumEqualAim(arr, 6));
        
    }
    

}
