package com.offer.class_02;
/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 *题目描述
 *求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 *为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共
 *出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,
 *并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的
 *次数（从1 到 n 中1出现的次数）。

 * @author yucang
 *
 */
public class C6_IntAppearOneTimes {
    
    /**
     * 这个答案不是这题目的
     * @param value
     * @return
     */
    public static int times(int value) {
        int times = 0;
        for(int i = 0; i < 32; i++) {
            times += (value >> i) & 1;
        }
        return times;
    }

}
