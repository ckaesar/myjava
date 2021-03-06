package com.kaesar.sword2offer;

import java.util.Stack;

/**
 * 标题：栈的压入、弹出序列
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * 题目链接：
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&&tqId=11174&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Jz21 {

  public boolean isPopOrder11(int[] pushA, int[] popA) {
    Stack<Integer> datas = new Stack<>();
    for(int i =0, j = 0; i < pushA.length || j < popA.length;) {
      if(datas.size() > 0 && datas.peek() == popA[j]) {
        datas.pop();
        j++;
      } else if( i < pushA.length) {
        datas.push(pushA[i]);
        i++;
      }
    }
    if(datas.size() == 0) {
      return true;
    }
    return false;
  }






















  public boolean isPopOrder(int[] pushA, int[] popA) {
    int n = pushA.length;
    Stack<Integer> stack = new Stack<Integer>();
    for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
      stack.push(pushA[pushIndex]);
      while (popIndex < n && !stack.isEmpty() && stack.peek() == popA[popIndex]) {
        stack.pop();
        popIndex++;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    int[] pushA = new int[] {1, 2, 3, 4, 5};
    int[] popA = new int[] {4, 5, 3, 2, 1};
    int[] popB = new int[] {1, 2, 3, 4, 5};
    Jz21 jz21 = new Jz21();
    System.out.println(jz21.isPopOrder11(pushA, popA));
    System.out.println(jz21.isPopOrder(pushA, popA));
    System.out.println(jz21.isPopOrder(pushA, popB));
  }
}


