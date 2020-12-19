package com.base.class_07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 最低的字典序
 * 给定一个字符串类型的数组strs,找到一种拼接方式,使得把所有字 符串拼起来之后形成的字符串具有最低的字典序
 * 思路
 * 分析题目有个“最”字，大概率是贪心问题
 * 贪心问题核心是找到某种排序方式
 * 字符本身对应了ASCII 码，加起来的和是最小也就最小
 * 
 * 思路
 * 贪心策略  贪心的核心是找到排序的策略
 * 使用优先队列
 * @author yucang
 *
 */
public class C7_LeastZidianXU {
    
    public static class Compator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }
    
    public static String getLeastZidianXu(String[] arr) {
        Arrays.sort(arr, new Compator());
        Stream<String> stream = Stream.of(arr);
        return stream.collect(Collectors.joining(","));
    }
    
    
}
