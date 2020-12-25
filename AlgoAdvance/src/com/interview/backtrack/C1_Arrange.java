package com.interview.backtrack;

import java.util.List;
import java.util.LinkedList;

public class C1_Arrange {

    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track) {
        //结束条件
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }

            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        C1_Arrange arrange = new C1_Arrange();
        List<List<Integer>> result = arrange.permute(new int[]{1, 2, 3});
        for (List<Integer> l : result){
            System.out.println(l.toString());
        }
    }

}
