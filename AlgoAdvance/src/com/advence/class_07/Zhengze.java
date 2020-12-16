package com.advence.class_07;
/**
 * https://juejin.cn/post/6844903779289022471#heading-31
 * 还是先搞出暴力递归
 * 分析可能性
 *  str: i
 *  exp: j j+1
 *  当j+1不是*的时候
 *  当j+1是*的时候
 *      *是>=0个所以要遍历，每种情况都要去试
 *  
 *  边界条件就是j到底了
 * @author yucang
 *
 */
public class Zhengze {
    
    public static boolean match(char[] str, int i, char[] exp, int j) {
        if(j == exp.length) {
           return i == str.length ? true : false; 
        }
        /**
         * 当第二个不是'*'的时候，处理最简单
         */
        if(j+1 != exp.length || exp[j+1] != '*') {
            if(i != str.length && str[i] == exp[j] || exp[j] == '.') {
                return match(str, i + 1, exp, j + 1);
            }
            return false;
        }
        /**
         * str = aaaabsd
         * exp = a*bsd || .*bsd || c*aaaabsd
         * 因为有可能是c*aaaabsd，所以跑不进循环，所以最后还是match(str, i, exp, j+2)
         */
        while(i != str.length && str[i] == exp[j] || exp[j] == '.') {
            if(match(str, i, exp, j+2)) {
                return true;
            }
            i++;
        }
        return match(str, i, exp, j+2);
    }
    
    public static boolean isMatch(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        return matchDp(str, exp);
    }

    public static boolean matchDp(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        char s[] = str.toCharArray();
        char e[] = exp.toCharArray();
        boolean[][] dpMap = initDpMap(s, e);

        //从倒数第二行开始推，每一行从右向左推
        for (int i = s.length - 1; i > -1; i--) {
            for (int j = e.length - 2; j > -1; j--) {
                if (e[j + 1] != '*') {
                    dpMap[i][j] = (s[i] == e[j] || e[j] == '.') && dpMap[i + 1][j + 1];
                } else {
                    int tmp = i;
                    while (tmp != s.length && (s[tmp] == e[j] || e[j] == '.')) {
                        if (dpMap[tmp][j + 2]) {
                            dpMap[i][j] = true;
                            break;
                        }
                        tmp++;
                    }
                    if (dpMap[i][j] != true) {
                        dpMap[i][j] = dpMap[i][j + 2];
                    }
                }
            }
        }
        return dpMap[0][0];
    }

    public static boolean[][] initDpMap(char[] s, char[] e) {
        boolean[][] dpMap = new boolean[s.length + 1][e.length + 1];
        //last column
        dpMap[s.length][e.length] = true;
        //last row -> i=s.length-1
        for (int j = e.length - 2; j >= 0; j = j - 2) {
            if (e[j] != '*' && e[j + 1] == '*') {
                dpMap[s.length - 1][j] = true;
            } else {
                break;
            }
        }
        //(str.length-1, e.length-1)
        if (s[s.length - 1] == e[e.length - 1] || e[e.length - 1] == '.') {
            dpMap[s.length - 1][e.length - 1] = true;
        }
        return dpMap;
    }

}
