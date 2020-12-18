package com.base.class_01;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTool implements Comparator<Integer>{
    // o1 - o2从小到大 反之则反之
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
    
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {
            10, 1, 2, 3, 4, 12, 8, 1, 9
        };
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new ComparatorTool());
        System.out.println(Arrays.toString(arr));
    }

}
