package com.advence.class_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个数组，数组中的每个数代表一座山的高度，这个数组代表将数组中的数从头到尾连接而成的环形山脉。
 * 比如数组[2,1,3,4,5]形成的环形山脉, 所有山峰中，能互相看到烽火的两两山峰的对数
 * 单调栈从大到小 
 * 入栈
 *  5 3 <-4进入的时候是3要结算，结算为两对
 *  5 4 4 4 4 5 K为4的个数，5进入要结算，结算对数为C(K,2)+K*2
 * 出栈
 *  5 5 4 4 3 3,还是C(K,2)+K*2
 *  但倒数第二条记录是
 *  5 5 4 4 4 4,还是C(K,2)+K*2
 *  5 4 4 4 4  C(K,2)+K
 *  都想象成一个环形考虑
 * 
 * @author yucang
 *
 */
public class SingleStackFengHuo {
    public static class Record{
        int value;
        int times;
        public Record(int value) {
            this.value = value;
            this.times = 1;
        }
    }

    public static int comunications(int[] arr) {
        //index of first max value
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }

        Stack<Record> stack = new Stack<>();
        stack.push(new Record(arr[maxIndex]));

        int res = 0;
        int index = nextIndex(arr, maxIndex);
        while (index != maxIndex) {
            // 这段代码必须放在前面，因为有可能遇到相等
            while (!stack.empty() && arr[index] > stack.peek().value) {
                Record record = stack.pop();
                res += getInternalPairs(record.times) + record.times * 2;
            }
            if (arr[index] == stack.peek().value) {
                stack.peek().times++;
            } else {
                stack.push(new Record(arr[index]));
            }
            index = nextIndex(arr, index);
        }

        while (!stack.empty()) {
            Record record = stack.pop();
            res += getInternalPairs(record.times);
            if (!stack.empty()) {
                res += record.times;
                if (stack.size() > 1) {
                    res += record.times;
                } else {
                    res += stack.peek().times > 1 ? record.times : 0;
                }
            }
        }
        return res;
    }

    //C(K,2)
    public static int getInternalPairs(int times){
        return (times * (times - 1)) / 2;
    }

    public static int nextIndex(int[] arr, int index) {
        return index < arr.length - 1 ? index + 1 : 0;
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 5, 4, 4, 4, 9,1};
        System.out.println(comunications(arr));
    }

}
