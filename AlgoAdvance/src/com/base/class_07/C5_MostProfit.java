package com.base.class_07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最大收益
 *输入: 
 *参数1,正数数组costs         costs[i]表示i号项目的花费
 *参数2,正数数组profits       profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 *参数3,正数k                k表示你不能并行、只能串行的最多做k个项目
 *参数4,正数m                m表示你初始的资金
 *
 *说明:你每做完一个项目,马上获得的收益,可以支持你去做下一个 项目。
 *输出: 你最后获得的最大钱数
 *思路：
 *"最"字大概率是贪心，贪心核心就是找到排序策略
 * 先找到能做的项目
 * 对能做的项目进行排序，花费从小到达，选择收益最大的
 * 做完了累加资本，再去找没做过能做的项目，遇到本金不够的也就停止了
 * 
 * 每次去找能做且收益最大的做，找不到了就终止
 *重复上述所说
 * @author yucang
 *
 */
public class C5_MostProfit {
    
    public static class Project{
        int cost;
        int profit;
        
        public Project(int cost, int profit) {
            super();
            this.cost = cost;
            this.profit = profit;
        }
        
    }
    
    public static class CostCompartor implements Comparator<Project>{
        @Override
        public int compare(Project o1, Project o2) {
            return o1.cost - o2.cost;
        }
    }
    
    public static class ProfitCompartor implements Comparator<Project>{
        @Override
        public int compare(Project o1, Project o2) {
            return o2.profit - o1.profit;
        }
    }
    
    public static int getMostProfit(int[] costs, int[] profits, int k, int m) {
        PriorityQueue<Project> costQueue = new PriorityQueue<>(new CostCompartor());
        PriorityQueue<Project> profitQueue = new PriorityQueue<>(new ProfitCompartor());
        for(int i = 0; i < costs.length; i++) {
            costQueue.add(new Project(costs[i], profits[i]));
        }
        for(int i = 0; i < k; i++) {
            // 每次把能做的项目放进去收益队列，即能做的
            while(!costQueue.isEmpty() && costQueue.peek().cost <= m) {
                profitQueue.add(costQueue.poll());
            }
            // 没有了能做的项目就退出了
            if(profitQueue.isEmpty()) {
                return m;
            }
            if(!profitQueue.isEmpty()) {
                m += profitQueue.poll().profit;
            }
            
        }
        return m;
    }
    
    public static void main(String[] args) {
        int[] costs = new int[] {};
        int[] profits = new int[] {};
        int k = 9;
        int m = 10;
    }

}
