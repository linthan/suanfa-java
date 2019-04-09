package chapter1;

import java.util.LinkedList;

// MaxMinusMinLessOrEqualNum 最大值减去最小值小于或者等于num的子数组数量
public class MaxMinusMinLessOrEqualNum {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 5, 6, 7, 10, 1, 4, 6, 7, 3, 2};
    MaxMinusMinLessOrEqualNum maxMinusMinLessOrEqualNum = new MaxMinusMinLessOrEqualNum();
    int ret = maxMinusMinLessOrEqualNum.getNum(arr, 5);
    System.out.print(ret);
  }
  //获取子数组对数
  public int getNum(int[] arr, int num) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    LinkedList<Integer> qmin = new LinkedList<>();
    LinkedList<Integer> qmax = new LinkedList<>();
    int i = 0;
    int j = 0;
    int res = 0;
    while (i < arr.length) {
      while (j < arr.length) {
        while ((!qmin.isEmpty()) && arr[qmin.peekLast()] >= arr[j]) {
          qmin.pollLast();
        }
        qmin.addLast(j);
        while ((!qmax.isEmpty()) && arr[qmax.peekLast()] <= arr[j]) {
          qmax.pollLast();
        }
        qmax.addLast(j);
        if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
          break;
        }
        j++;
      }
      if (qmin.peekFirst() == i) {
        qmin.pollFirst();
      }
      if (qmax.peekFirst() == i) {
        qmax.pollFirst();
      }
      res += j - i;
      i++;
    }
    return res;
  }
}
