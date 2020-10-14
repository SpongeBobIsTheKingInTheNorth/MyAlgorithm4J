/*
 * Copyright (c) 2015-2020, Zhejiang QiZhi Technologies Co., Ltd.
 * <http://www.shterm.com/>
 */
package com.liy.sort;

/**
 * 归并排序
 * @author liyang
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        int m = left + (right - left) / 2;
        // 递归拆分
        mergeSort(arr, left, m);
        mergeSort(arr, m + 1, right);
        // 归并再排序
        merge(arr, left, m, right);
    }

    public static void merge(int[] arr, int left, int m, int right) {
        int[] l = new int[m - left + 1];
        int[] r = new int[right - m];
        int leftLen = l.length;
        int rightLen = r.length;
        // 赋值
        for (int i = 0; i < leftLen; i++) {
            l[i] = arr[left + i];
        }
        for (int i = 0; i < rightLen; i++) {
            r[i] = arr[m + i + 1];
        }
        int leftIndex = 0, rightIndex = 0, arrIndex = left;
        while (leftIndex < leftLen && rightIndex < rightLen) {
            if (l[leftIndex] < r[rightIndex]) {
                arr[arrIndex] = l[leftIndex];
                leftIndex++;
            } else {
                arr[arrIndex] = r[rightIndex];
                rightIndex++;
            }
            arrIndex++;
        }
        while (leftIndex < leftLen) {
            arr[arrIndex] = l[leftIndex];
            leftIndex++;
            arrIndex++;
        }
        while (rightIndex < rightLen) {
            arr[arrIndex] = r[rightIndex];
            rightIndex++;
            arrIndex++;
        }
    }

}
