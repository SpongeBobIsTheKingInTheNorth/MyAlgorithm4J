package com.liy.sort;

import java.util.Arrays;

/**
 * 基数排序
 * 平均时间复杂度O(d(n+r))，最坏O(d(n+r))，最好O(d(n+r))， 空间复杂度O(n+r)， 稳定排序
 * 其中r为基数(0~9)，d为位数(数字最大有多少位)
 * @author liyang
 */
public class RadixSort {

    // 实际排序
    public static void radixSort(int[] nums) {
        final int len = nums.length;
        // 设置10个桶
        int[] bucket = new int[10];
        int[] sorted = new int[len];
        // 当前的计算的位置
        int index = 1;
        int max = Arrays.stream(nums).max().getAsInt();
        while (max >= index) {  // 用于控制排序结束的条件
            if (index > 1) {
                // 如果不是第一次排序，需要重置nums里的数字
                for (int i = 0; i < 10; i++) {
                    bucket[i] = 0;
                }
            }
            // 计算每个桶里有多少数字
            for (int i = 0; i < len; i++) {
                bucket[getNumOnIndex(nums[i], index)]++;
            }
            // 再计算每个桶对应数组的边界位置
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            // 将数字从ints中去除并放置到bucket中对应的位置下
            for (int i = len - 1; i >= 0; i--) {
                // 再次计算该数字在nums中的下标
                int dig = getNumOnIndex(nums[i], index);
                sorted[--bucket[dig]] = nums[i];
            }
            // 将本次排序后的数组复制回ints中
            System.arraycopy(sorted, 0, nums, 0, len);
            index *= 10;
        }
    }

    // 计算num在指定位置上的数字， 如个位，十位或百位数字
    private static int getNumOnIndex(int num, int index) {
        return num / index % 10;
    }
}
