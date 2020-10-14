/*
 * Copyright (c) 2015-2020, Zhejiang QiZhi Technologies Co., Ltd.
 * <http://www.shterm.com/>
 */
package com.liy.sort;

/**
 * 插入排序算法实现
 * 平均时间复杂度O(N<sup>2</sup>)，最坏O(N<sup>2</sup>)，最好O(N)， 空间复杂度O(1)， 稳定排序
 * @author liyang
 */
public class InsertSort {

    private static void sort(int[] ints) {
        // 1.首次排序， 认为[0, 0]数组有序， 因为只有1个元素.
        // 2.从index=1的元素开始进行插入排序
        for (int i = 1; i < ints.length; i++) {
            // 认为[0, i - 1]的位置有序
            int tmp = ints[i];
            int j;
            // 3.从有序数组的最后一位开始比较，大于tmp则向后移动一位
            for (j = i - 1; j >= 0 && tmp < ints[j]; j--) {
                ints[j + 1] = ints[j];
            }
            // 4.移动结束后， j+1即为当前插入的元素的位置.
            ints[j + 1] = tmp;
            System.out.println(SortUtils.format(ints));
        }
    }

}
