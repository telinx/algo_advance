package com.base.class_07;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 一些项目要占用一个会议室宣讲,会议室不能同时容纳两个项目的宣讲。 给你每一个项目开始的时间和结束的时间(给你一个数组,里面 是一个个具体的项目),你来安排宣讲的日程,要求会议室进行 的宣讲的场次最多。返回这个最多的宣讲场次。
 * 思路
 * 贪心思想，在当前作出最优决策
 * 贪心最优决策就是根据什么理由进行排序
 * 本题目是根据最早结束时间进行排序
 * 
 * 核心思想：
 * 还是贪心
 * 找出最优排序策略
 * 排除不符合会议开始时间start的会议
 * @author yucang
 *
 */
public class C8_ArrangeMeeting {
    
    public static class Meeting{
        int start;
        int end;
        
        public Meeting(int start, int end) {
            this.start = this.start;
            this.end = this.end;
        }
    }
    
    public static class Comparator1 implements Comparator<Meeting>{
        @Override
        public int compare(Meeting o1, Meeting o2) {
            return o1.end - o2.end;
        }
    }
    
    public static int arrangeMeeting(Meeting[] arr, int start) {
        int res = 0;
        Arrays.sort(arr, new Comparator1());
        for(Meeting meeting : arr) {
            if(meeting.start >= start) {
                res++;
                start = meeting.end;
            }
        }
        return res;
    }

}
