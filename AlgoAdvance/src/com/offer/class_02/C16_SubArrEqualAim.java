package com.offer.class_02;
/**
 * 和为S的连续正数序列
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? 
 * Good Luck!
 * 
 * 
 * 思想用两个指针L R sum
 * 范围 1～（target/2 + 1）
 * sum < target R右移动
 * sum > target L右移动
 * sum == target 输入且减去最后一个
 * @author yucang
 *
 */
public class C16_SubArrEqualAim {
    
    public static void subArrEqualAim(int n) {
        int end = n/2 + 1;
        int start = 1;
        int L = start;
        int R = 2;
        int sum = 3;
        
        while(R <= end && L < R) {
            if(sum < n) {
                sum += ++R;
            }else if(sum > n) {
                sum -= L++;
            }else {
                
                print(L, R);
                sum -= L++;
            }
        }
        
    }
    
    public static void main(String[] args) {
        subArrEqualAim(100);
    }
    
    public static void print(int i, int j) {
        for(;i <=j; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

}
