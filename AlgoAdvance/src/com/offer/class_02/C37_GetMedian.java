package com.offer.class_02;

/**
 * 数据流的中位数
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。

 * 1.创建一个大根堆， 一个小根堆
 * 2.入的数如果比 大根堆 堆顶小入大根堆，否则入小根堆
 * 3.两个堆的大小要均衡，当大于等于2，挪堆顶的给对方
 */
public class C37_GetMedian {
}
