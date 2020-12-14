package com.advence.class_02;

/**
 * 查找一个数组第几小的数
 * 步骤
 * 1. 每5个划分一组，该组进行插入排序，提取中位数
 * 2. 提取中位数数组，再从中位数集合中提取中位数
 * 3. 利用荷兰国旗算法(等于k的做左边，等于k的在右边)算出位置
 * 
 * 知识基础：
 *  插入排序
 *  荷兰过期
 *  递归
 *  
 * 操作对象
 * array k
 * @author yucang
 *
 */
public class BFRPT {
    
    public static int bfrpt(int[] array, int begin, int end, int k) {
        if(array == null || array.length < k) {
            return -1;
        }
        if(begin == end) {
            return array[begin];
        }
        int pivot = getMedian(array, begin, end);
        int[] edges = northLand(array, begin, end, pivot);
        if(k >= edges[0] &&  k <= edges[1]) {
            return array[edges[0]];
        }else if(k < edges[0]) {
            return bfrpt(array, begin, edges[0] - 1, k);
        }else {
            return bfrpt(array, edges[1] + 1, end, k);
        }
    }
    
    public static int getMedian(int[] array, int begin, int end) {
        int len = end - begin;
        len = len % 5 == 0 ? len / 5 : len / 5 + 1;
        int[] medianArray = new int[len];
        int start = begin;
        for(int i = 1; i <= len; i ++) {
            int tem = start + i * 5 - 1;
            int stop = tem < end ? tem :  end;
            medianArray[i - 1] = get5Median(medianArray, start, stop);
        }
        // 再取中位数，就是len/2, 注意右界限是len - 1
        return bfrpt(medianArray, 0, len - 1, len/2);
    }
    
    public static int get5Median(int[] array, int start, int stop) {
        insetSort(array, start, stop);
        int media = (stop + start)/2;
        return array[media];
    }
    
    public static void insetSort(int[] array, int start, int stop) {
        // 注意核心思想，临时存储初始计算位置的值，当前值的比前一个小，前一个往后挪，挪到停下就放初始计算位置的值
        for(int i = (start + 1); i <= stop; i++) {  
            int temp = array[i];
            int j = i;
            while(j > (start + 1) && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j]=temp;
        }
    }
    
    /**
     * 荷兰国旗核心思想
     * 左右连个括号L R，还有游标i, 比较值 pivot， i < R
     * array[i] > pivot, swap(array, i, --R);
     * array[i] < pivot, swap(array, i++, ++L);
     * 之外就是i++
     * @param array
     * @param start
     * @param stop
     * @param pivot
     * @return
     */
    public static int[] northLand(int[] array, int start, int stop, int pivot) {
        
        int[] edges = new int[2];
        int L = start - 1;
        int R = stop + 1;
        int i = start;
        while(i <= R) {  // 注意此处括到了 也就不括了
            if(array[i] > pivot) {
                swap(array, i, --R);
            }else if(array[i] < pivot){
                swap(array, i++, ++L);
            }else {
                i++;
            }
        }
        edges[0] = L + 1;
        edges[0] = R - 1;
        return edges;
    }
    
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] array = new int[] {
                10, 2, 3, 4 , 88, 12, 1,3, 44, 42
        };
        int k = 3;
        bfrpt(array, 0, array.length - 1, k);
    }
}
