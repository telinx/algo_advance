package com.offer.class_02;

import java.util.Arrays;

/**
 * 扑克牌顺子
 * 题目描述
 * LL今天心情特别好,因为他去买了一副扑克牌,
 * 发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
 * 如果抽到的话,他决定去买体育彩票,
 * 嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子
 * .....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就
 * 可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 
 * 现在,要求你使用这幅牌模拟上面的过程,
 * 然后告诉我们LL的运气如何， 
 * 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 * @author yucang
 *
 */
public class C20_Shunzi {
    
    /**
     * 思路
     * arr[i] arr[i-1]相等 return false;
     * slot = arr[i] - arr[i-1]
     * 计算非王的差值和 和 王的张数
     * @param arr
     * @return
     */
    public boolean isContinuous(int [] arr) {
        boolean res = false;
        Arrays.sort(arr);
        int kings = 0;
        int slot = 0;
        for(int i = 0; i < arr.length; i++) {
            
            if(i > 0 && arr[i - 1] != 0) {
                // arr[i]因为排序了不可能是0  计算非王的差值和
                if(arr[i] == arr[i-1]) {
                    return false;
                }else {
                    slot += arr[i] - arr[i-1] -1;
                }
            }
            kings = arr[i] == 0 ? ++kings : kings;
        }
        return kings >= slot;
    }
}
