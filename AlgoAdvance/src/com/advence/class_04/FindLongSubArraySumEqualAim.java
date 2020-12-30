package com.advence.class_04;

import java.util.HashMap;
import java.util.Map;

public class FindLongSubArraySumEqualAim {

    public static int findLongSubArraySumEqualAim(Integer[] array, int aim){
        if(array == null){
            // throw exception
        }
        int len = 0;
        Integer sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < array.length; i++){
            sum += array[i];
            //这段代码很重要，因为要提取最长的，比方0-2 = sum - aim, 0-4 = sum - aim
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            if(map.containsKey(sum - aim)){
                len = Math.max(len, i - map.get(sum - aim));
            }

        }
        return len;

    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{
                7, 3, 2, 1, 1, 7, -6, -1, 7
        };
        System.out.println(findLongSubArraySumEqualAim(array, 7));
    }


    public static int maxSubArrs(int[] arr) {
        if (arr == null) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int curXorSum = 0;
        int res = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            curXorSum ^= arr[i];
            //case 1，之前没有出现过这个异或和，那么该位置上的dp等于前一个位置的dp
            if (!map.containsKey(curXorSum)) {
                dp[i] = i > 0 ? dp[i - 1] : 0;
            } else {
                //case 2，之前出现过这个异或和，那么之前这个异或和出现的位置到当前位置形成的子数组异或和为0
                int index = map.get(curXorSum);
                dp[i] = index > 0 ? dp[index] + 1 : 1;
            }
            //把最近出现的异或和都记录下来，因为要划分出最多的异或和为0的子数组
            map.put(curXorSum, i);
        }
        //最后一个位置的dp就是整个问题的解
        return dp[dp.length -1];
    }

    //public static void main(String[] args) {
    //    int arr[] = {1, 2, 3, 0, 2, 3, 1, 0, 4, 1, 3, 2};
    //    System.out.println(maxSubArrs(arr));
    //    System.out.println(getXor(arr));
    //}
    //
    /**
     * 
     * @param arr
     * @return
     */
    public static int getXor(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);                   // xurSum为key, value为下标， value累加xurSum的最新下标，比如下标3累加为1， 下班6累加为1,只记载6
        int[] dp = new int[arr.length];   // dp累加
        int xurSum = 0;
        for(int i = 0; i < arr.length; i++) {
            xurSum = xurSum ^ arr[i];
            if(!map.containsKey(xurSum)) {
                dp[i] = i > 0 ? dp[i - 1] : 0;
            }else {
                int index = map.get(xurSum);
                dp [i] = index > 0 ? dp[index] + 1 : 1;
            }
            map.put(xurSum, i);
        }
        return dp[dp.length - 1];
    }
    
//   


}
