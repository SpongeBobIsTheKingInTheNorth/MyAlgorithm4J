/*
 * Copyright (c) 2015-2020, Zhejiang QiZhi Technologies Co., Ltd.
 * <http://www.shterm.com/>
 */
package com.liy.sort;

import java.util.Arrays;

/**
 * 冒泡排序的实现
 * 平均时间复杂度O(N<sup>2</sup>)，最坏O(N<sup>3</sup>)，最好O(N)， 空间复杂度O(1)， 稳定排序
 * @author liyang
 */
public class BubbleSort {

    /**
     * 冒泡排序， 将大的数字向后移动
     * @param ints 需要排序的数组
     */
    private static void bubbleSort1(int[] ints) {
        int count = 0;
        for (int i = 0; i < ints.length - 1; i++) {
            boolean changed = false;
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j] > ints[j + 1]) {
                    int tmp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = tmp;
                    changed = true;
                    count++;
                }
            }
            if (!changed) {
                break;
            }
        }
        System.out.println("排序次数：" + count);
    }

    /**
     * 冒泡排序, 小的数字往前移动
     * @param ints 需要排序的数组
     */
    private static void bubbleSort2(int[] ints) {
        int count = 0;
        for (int i = 0; i < ints.length - 1; i++) {
            boolean changed = false;
            for (int j = ints.length - 1; j > i; j--) {
                if (ints[j] < ints[j - 1]) {
                    int tmp = ints[j];
                    ints[j] = ints[j - 1];
                    ints[j - 1] = tmp;
                    changed = true;
                    count++;
                }
            }
            if (!changed) {
                break;
            }
        }
        System.out.println("排序次数：" + count);
    }

}
