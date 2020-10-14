/*
 * Copyright (c) 2015-2020, Zhejiang QiZhi Technologies Co., Ltd.
 * <http://www.shterm.com/>
 */
package com.liy.sort;

/**
 * 快速排序算法实现
 * 平均时间复杂度O(N*log<sub>2</sub>N)，最坏O(N<sup>2</sup>)，最好O(N)， 空间复杂度O(N*log<sub>2</sub>N)
 * 相等元素可能会因为分区而交换顺序，所以它是不稳定的算法
 * @author liyang
 */
public class QuickSort {

    private static void sort(int[] ints, int left, int right) {
        if (left >= right) {
            // 7.left， right相等时， 证明数组已排序完成
            return;
        }
        int splitIndex = split(ints, left, right);
        System.out.println(SortUtils.format(ints));
        // 以left为中间 分割为2个数组
        sort(ints, left, splitIndex - 1);
        sort(ints, splitIndex + 1, right);
    }

    /**
     * 分割数组中指定的位置
     * @param ints 数组
     * @param left 左侧边界
     * @param right 右侧边界
     * @return 分割中间线
     */
    private static int split(int[] ints, int left, int right) {
        // 1.将左侧边界数值作为本次对比的基准值，在对比过程中不变
        int base = ints[left];
        while (left < right) {
            // 2.期望右侧数据大于等于base, right向左移动， 找到第一个小于base的数值
            while (left <  right && ints[right] >= base) {
                right--;
            }
            // 3.将小于base的数值放到左侧
            ints[left] = ints[right];
            // 4.期望左侧数值小于等于base， left向右移动，找出第一个大于base的数值
            while (left < right && ints[left] <= base) {
                left++;
            }
            // 5.将大于base的数值放到右侧
            ints[right] = ints[left];
            // 6.重复循环，直到left=right. 达到条件后，left左侧数据均小于left, left右侧数据均大于left
            // 以left为依据，将数组分割为2部分。再分别计算左侧和右侧的数据
        }
        ints[left] = base;
        return left;
    }

}
