package com.interview.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组可能包含重复项的整数，nums返回所有可能的子集。
 *
 * 注意：解决方案集不能包含重复的子集。
 * https://blog.csdn.net/wonner_/article/details/80373871
 */
public class C3_Combination {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(ret,new ArrayList<>(),nums,0);
        return ret;
    }

    public static void backtracking(List<List<Integer>> ret,List<Integer> list,int[] nums,int position) {
        ret.add(new ArrayList<>(list));
        for(int i=position;i<nums.length;i++) {
            if(i>position&&nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            backtracking(ret,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ret = subsetsWithDup(new int[]{
                1,2,2
        });

        for(List<Integer> list : ret){
            System.out.println(list.toString());
        }
    }


}
