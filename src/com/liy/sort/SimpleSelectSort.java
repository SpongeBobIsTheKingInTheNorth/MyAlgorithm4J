/*
 * Copyright (c) 2015-2020, Zhejiang QiZhi Technologies Co., Ltd.
 * <http://www.shterm.com/>
 */
package com.liy.sort;

/**
 * 简单选择排序
 * 平均时间复杂度O(N<sup>2</sup>)，最坏O(N<sup>2</sup>)，最好O(N)， 空间复杂度O(1)， 不稳定排序
 * @author liyang
 */
public class SimpleSelectSort {

    private static void sort(int[] ints) {
        int tmp;
        int minIndex = 0;
        for (int i = 0; i < ints.length; i++) {
            // 循环无序队列，找出其中的最小值，跟有序队列后面的一位交换位置
            // i表示最小值应该放置的位置
            tmp = Integer.MAX_VALUE;
            for (int j = i; j < ints.length; j++) {
                if (ints[j] < tmp) {
                    tmp = ints[j];
                    minIndex = j;
                }
            }
            ints[minIndex] = ints[i];
            ints[i] = tmp;
            System.out.println(SortUtils.format(ints));
        }
    }

}
