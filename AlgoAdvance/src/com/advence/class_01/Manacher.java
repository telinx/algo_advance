package com.advence.class_01;

/**
 * 核心思想
 * 1.字符间隔加#号
 * 2.实际回文长度 = p[i](回文半径) - 1
 * 3.起始点= (i(圆心) - 回文长度（p[i] - 1）)/2
 * 4.终止点 = 起始点 + 回文长度
 * 
 * Manacher四种情况
 * i在R之外，R往右走，
 * i在R之内
 *  i i`的回文范围在R内
 *  i`的的回文范围超出了R
 *  i i`的回2文范围正好在R边际，R向右走
 * @author yucang
 *  
 * 步骤
 * 1.处理成奇数长度数据加$#@，chars
 * 2.遍历chars
 *  2.1 推理出p[i] = R < i ? 1 : Math.min(p[2*id - i], R - i);
 *  2.2 以i为圆心向外扩
 *  2.3 若 R < i + p[i]，将R设置为当前最大回文右边点，回文圆心设置为i
 *  2.4 若 maxLen < (p[i] - 1),更改当前maxLen，保存此时的圆心index
 *  
 *3.推理出start = (index - maxLen)/2, end = start + maxLen
 *
 * 重点
 * p[i]
 * R回文右边最远边界
 * id圆心
 */
public class Manacher {
    
    public static String addSignal(String target) {
        String t = "$";
        for (int i=0; i<target.length(); i++) {
            t += "#" + target.charAt(i);
        }
        // 尾部再加上字符@，变为奇数长度字符串
        t += "#@";
        return t;
    }
    
    public static String manacher(String target) {
        if(target == null) {
            return "非法";
        }else if(target.length() == 1) {
            return target;
        }
        String chars = addSignal(target);

        int[] p = new int[chars.length()];// 回文半径
        int mx = 0; //每次能回文最大的右边直径点
        int id = 0;

        int maxLength = -1;
        int index = 0; //最长回文圆心
        for(int i= 1; i < chars.length() - 1; i++) {
            p[i] = mx > i ? Math.min(p[2*id - i], mx - i) : 1;
            while((i + p[i]) < chars.length() && (i - p[i]) >= 0) {
                if(chars.charAt(i + p[i]) == chars.charAt(i - p[i])) {
                    p[i]++;
                }else {
                    break;
                }
            }

          if (mx < p[i] + i) {
              mx = p[i] + i;
              id = i;
          }
          // 如果回文子串的长度大于maxLength，则更新maxLength和index的值
          if (maxLength < p[i] - 1) {
              maxLength = p[i] - 1;
              index = i;
          }
        }

        System.out.println("maxLen====>" + maxLength);
        int start = (index - maxLength)/2;
        int end = start + maxLength;
        return target.substring(start, end);
    }
    
    public static void main(String[] args) {
        String a = "ABAB";
        System.out.println(addSignal(a));
        String b = "CABBAD";
        System.out.println(manacher(b));
    }
    
    public static String Manacher(String s) {
        if (s.length() < 2) {
            return s;
        }
        // 第一步：预处理，将原字符串转换为新字符串
        String t = "$";
        for (int i=0; i<s.length(); i++) {
            t += "#" + s.charAt(i);
        }
        // 尾部再加上字符@，变为奇数长度字符串
        t += "#@";
        // 第二步：计算数组p、起始索引、最长回文半径
        int n = t.length();
        // p数组
        int[] p = new int[n];
        int id = 0, mx = 0;
        // 最长回文子串的长度
        int maxLength = -1;
        // 最长回文子串的中心位置索引
        int index = 0;
        for (int j=1; j<n-1; j++) {
            // 参看前文第五部分
            p[j] = mx > j ? Math.min(p[2*id-j], mx-j) : 1;
            // 向左右两边延伸，扩展右边界
            while (t.charAt(j+p[j]) == t.charAt(j-p[j])) {
                p[j]++;
            }
            // 如果回文子串的右边界超过了mx，则需要更新mx和id的值
            if (mx < p[j] + j) {
                mx = p[j] + j;
                id = j;
            }
            // 如果回文子串的长度大于maxLength，则更新maxLength和index的值
            if (maxLength < p[j] - 1) {
                // 参看前文第三部分
                maxLength = p[j] - 1;
                index = j;
            }
        }
        // 第三步：截取字符串，输出结果
        // 起始索引的计算参看前文第四部分
        int start = (index-maxLength)/2;
        return s.substring(start, start + maxLength);
    }
    
}
