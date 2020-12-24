package com.offer.class_01;

import java.util.Arrays;

/**
 * 旋转数组的最小数字
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *

 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class C7_ReverseArr {

    public static void main(String[] args) {
        int[] arr = new int[]{
                3,4,5,1,2
        };
        reverseArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArr(int[] arr) {
        // return 非法
        int minIndex = getMinIndex(arr);
        change(arr, 0, minIndex-1);
        System.out.println(Arrays.toString(arr));
        change(arr, minIndex, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        change(arr, 0, arr.length - 1);

    }

    public static void change(int[] arr, int m, int n) {
        for(int i = m, j = n; i < j; i++, j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static int getMinIndex(int[] arr) {
        int minIndex = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
    }
}
