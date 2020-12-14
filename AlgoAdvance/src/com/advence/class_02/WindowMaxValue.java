package com.advence.class_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 核心思想：
 * 利用双端队列
 * 头到尾 从大到小，保证队头取出来是最大的
 * 移除过期值 i - dueue.peekFirt() == w
 * 第i >= w-1的时候开始记录值，总共i-w-1个
 * 
 * 扩展要是获取窗口最小的，还是双端队列，保证队头是最小的
 * @author yucang
 *
 */
public class WindowMaxValue {

    public static List<Integer> getWindowMaxValue(int [] arr, int w){
        List<Integer> list = new ArrayList<Integer>();
        LinkedList<Integer> dueue = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            int value = arr[i];
            while(!dueue.isEmpty() && arr[dueue.peekLast()] < value) {
                dueue.pollLast();
            }
            dueue.add(i);
            if(i - dueue.peekFirst() == w) {
                dueue.pollFirst();
            }
            if(i > w-1) {
                list.add(arr[dueue.peekFirst()]);
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        List<Integer> maxWindows = getWindowMaxValue(arr, 3);
        for(int i = 0; i < maxWindows.size(); i++)
        {
            System.out.print(maxWindows.get(i) + "\t");
        }
    }
    
}
