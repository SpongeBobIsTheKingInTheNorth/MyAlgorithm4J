/*
 * Copyright (c) 2015-2020, Zhejiang QiZhi Technologies Co., Ltd.
 * <http://www.shterm.com/>
 */
package com.liy.sort;

/**
 * 堆排序实现
 * @author liyang
 */
public class HeapSort {

    private static void sort(int[] ints) {
        // 循环建立初始堆
        for (int i = ints.length / 2; i >= 0; i--) {
            HeapAdjust(ints, i, ints.length);
        }

        // 进行n-1次循环，完成排序
        for (int i = ints.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = ints[i];
            ints[i] = ints[0];
            ints[0] = temp;

            // 筛选 R[0] 结点，得到i-1个结点的堆
            HeapAdjust(ints, 0, i);
            System.out.format("第 %d 趟: \t", ints.length - i);
            System.out.println(SortUtils.format(ints));
        }
    }

    public static void HeapAdjust(int[] array, int parent, int length) {
        int temp = array[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子

        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= array[child]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            array[parent] = array[child];

            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }

        array[parent] = temp;
    }

}
