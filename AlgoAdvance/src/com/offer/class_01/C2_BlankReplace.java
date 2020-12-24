package com.offer.class_01;

public class C2_BlankReplace {

    public static String replace(StringBuffer buffer){
        String res = null;
        if(buffer == null || buffer.length() < 1) {
            return res;
        }
        int blankCnt = 0;
        for(int i = 0; i<buffer.length();i ++){
            if(buffer.charAt(i) == ' '){
                blankCnt++;
            }
        }
        int point = buffer.length() - 1;
        int newPoint = point + 2 * blankCnt;
        buffer.setLength(newPoint + 1);

        while(point > 0 && newPoint > 0){
            if(buffer.charAt(point) == ' '){
                buffer.setCharAt(newPoint--, '0');
                buffer.setCharAt(newPoint--, '2');
                buffer.setCharAt(newPoint--, '%');
            }else{
                buffer.setCharAt(newPoint--, buffer.charAt(point));
            }
            point--;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String str = "I Love You, DO You Love Me?";
        str = replace(new StringBuffer(str));
        System.out.println(str);
    }

}
