package com.kaesar.sword2offer;

import java.util.*;

/**
 * 标题：数据流中的中位数
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 题目链接：
 * https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&&tqId=11216&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Jz63 {

  /* 大顶堆，存储左半边元素 */
  private PriorityQueue<Integer> left;
  /* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
  private PriorityQueue<Integer> right = new PriorityQueue<>();
  /* 当前数据流读入的元素个数 */
  private int N = 0;

  public Jz63() {
    left = new PriorityQueue<>((o1, o2) -> o2 - o1);
  }

  public void insert(Integer num) {
    /* 插入要保证两个堆存于平状态 */
    if (N % 2 == 0) {
      /* N 为偶数的情况下插入到右半边。
       * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
       * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
      left.add(num);
      right.add(left.poll());
    } else {
      right.add(num);
      left.add(right.poll());
    }
    N++;
  }

  public Double getMedian() {
    if (N % 2 == 0) {
      return (left.peek() + right.peek()) / 2.0;
    } else {
      return (double) right.peek();
    }
  }

  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<>();
    list1.add(2);
    list1.add(1);
    list1.add(5);
    list1.add(11);
    list1.add(4);
    for(int n: list1) {
      System.out.print(n + " ");
    }
    System.out.println();
    Collections.sort(list1);
    for(int n : list1) {
      System.out.print(n + " ");
    }
  }
}