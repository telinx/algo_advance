package com.advence.class_03;

import java.util.Stack;

/**
 * 找出矩阵中一片1相连的最大矩形
 * 思路单调栈，从小到大  底部到顶部
 * 1.把矩阵的每一列想成一个塔，记录每一列塔的高度,
 * 2.塔的高度是累加出来的，塔底部是0，则高度都为0
 * 3.结算面积是，根据单调栈的压入弹出，
 * 4.核心思想就在当前高度 左右边界可到达的范围 × 高度，
 * 5.如果压入的数字比栈顶的数小，说明栈顶高度的右边界出现了，左边界为-1该结算
 * 6.栈内剩余的数据，右边界是array.length，但左边界就是栈的下一个
 * @author yucang
 *
 */
//0   1   1   1
//1   1   1   0
//1   1   1   0
//1   0   1   0
public class SingleStackFindMatrixMaxBlock {
    
    public static int getMatrixMaxBlock(Integer[][] array) {
        int[] height = new int[array[0].length];
        int area = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                height[j] = array[i][j] == 0 ? 0 : height[j] + 1;
            }
            area = Math.max(getMatrixMaxBlockRow(height), area);
        }
        return area;
    }
    
    /**
     * 从小到大  底部到顶部
     * @param height
     * @return
     */
    public static int getMatrixMaxBlockRow(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int area = Integer.MIN_VALUE;
        for(int i = 0; i < height.length; i++) {
            // 注意这是while 直到栈顶比他小
            while(!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int currentHeightIndex = stack.pop();
                //当前高度的左边界, 右边界为i
                int leftBorder = stack.isEmpty() ? - 1 : stack.peek();
                area = Math.max(area, height[currentHeightIndex] * (i - leftBorder -1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int currentHeightIndex = stack.pop();
            //当前高度的左边界, 右边界为i
            int rightBorder = height.length;
            int leftBorder = stack.isEmpty() ? - 1 : stack.peek();
            area = Math.max(area, height[currentHeightIndex] * (rightBorder - leftBorder -1));
        }
        return area;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4, 2, 3, 6};
        System.out.println(getMatrixMaxBlockRow(array));
        Integer[][] matrix = new Integer[][] {
            {0, 1, 0, 1},
            {1, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 0, 1, 1},
        };
        System.out.println(getMatrixMaxBlock(matrix));
    }

}
