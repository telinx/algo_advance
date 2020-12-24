package com.offer.class_02;

/**
 * 翻转单词顺序列
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，
 * “student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author yucang
 *
 */
public class C19_ReverseSentence {
    
    public static void main(String[] args) {
        reverseSentence("student. a am I");
    }
    /**
     * “student. a am I”
     * “I am a student.”
     * @param sentence
     */
    public static void reverseSentence(String sentence) {
        char[] arr = sentence.toCharArray();
        swap(arr, 0, arr.length - 1);
        System.out.println(new String(arr));
        int L = 0;
        int R = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ') {
                R = i - 1;
                swap(arr, L, R);
                System.out.println(i + "--"+ L + "--" + R +"--" +new String(arr));
                L = i + 1;
            }
           
        }
        if(L <= arr.length - 1) {
            swap(arr, L, arr.length - 1);
        }
        System.out.println(new String(arr));
    }
    
    public static void swap(char[] arr, int m, int n) {
        for(; m < n; m++, n--) {
            char temp = arr[m];
            arr[m] = arr[n];
            arr[n] = temp;
        }
    }
    
}
