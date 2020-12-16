package com.base.class_01;

import java.util.Arrays;
/**
 * 堆基础只是复习
 * 1.二叉树第i曾最多 2^(i-1)节点
 * 2.深度为k的至多有 2^k - 1
 * 3.包含n个节点的二叉树高度至少logn + 1
 * 4.当前节点序号为n,左节点是2n+1, 右节点是2n+2
 * 
 * 堆排序步骤
 * 建立堆
 * 堆顶弹出，堆顶调整
 * 
 * 建立堆
 * 堆的调整
 * 从（length - 1）/2位置开始建立堆
 * @author yucang
 *
 */
public class HeapSort {
    
    /**
     * 想象一下就是 斜坡版的插入排序,parent相当与那个j
     * @param arr
     * @param i
     * @param length
     */
    public static void adjust1(Integer[] arr, int i , int length) {
        int parent = i;
        int left = 2 * i + 1;
        int temp = arr[parent];
        while(left < length) {
            int right = left + 1;
            if(right < length && arr[right] > arr[left]) {
                left = right;
            }
            if(arr[parent] > arr[left]) {
                break;
            }
            arr[parent] = arr[left];
            parent = left;
            left = 2 * left + 1;
        }
        arr[parent] = temp;
    }
    
    public static void heapSort(Integer[] arr) {
        int length = arr.length;
        //假设高度是h, 从h - 1开始构建最大堆
        
        for(int i = (length - 1)/2; i >= 0; i-- ) {
            adjust(arr, i, length);
        }
        for(int i = length -1; i >=0 ; i--) {
            SortUtils.swap(arr, 0, i);
            adjust(arr, 0, i);
        }
    }
    
    public static void adjust(Integer[] arr, int i, int length) {
        int left = 2*i +1;
        int parent = i;
        int temp = arr[parent];//将temp作为父节点
        while(left < length) {
            int right = left + 1;
            if(right < length && arr[left] < arr[right]) {
                left = right;
            }
            if(arr[parent] > arr[left]) {
                break;
            }
            arr[parent] = arr[left];
            parent = left;
            left = 2 * parent + 1;
        }
        arr[parent] = temp;
    }
    
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {
            10, 1, 2, 3, 4, 12, 8, 1, 9
        };
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
