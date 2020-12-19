package com.base.class_08;
/**
 * 打印一个字符串的全部子序列,包括空字符串
 * @author yucang
 *
 */
public class C3_PrintSubArr {
    
   public static void process(char[] chars, int i, String res) {
       if(i == chars.length) {
           // i 跑到了最后打印出结果
           System.out.println(res);
           return;
       }
       process(chars, i+1, res + chars[i]);
       process(chars, i+1, res);
   }
   
   public static void main(String[] args) {
       process("abc".toCharArray(), 0, "");
   }
}
