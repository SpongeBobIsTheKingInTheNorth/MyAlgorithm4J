/*
 * Copyright (c) 2015-2020, Zhejiang QiZhi Technologies Co., Ltd.
 * <http://www.shterm.com/>
 */
package com.liy.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 排序算法的工具
 * @author liyang
 */
public class SortUtils {

    /**
     * 生成指定数量的数字， 取值范围[0, 100]
     * @param size 数量
     * @return 数据
     */
    public static int[] randomInts(int size) {
        int[] ints = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            ints[i] = rd.nextInt(100);
        }
        return ints;
    }

    public static int[] sortByDescInts(int size) {
        List<Integer> list = new ArrayList<>(size);
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rd.nextInt(100));
        }
        list.sort((v1, v2) -> {
            return v2.compareTo(v1);
        });
        System.out.println(list);
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    /**
     * 格式化数组
     * @param ints 数组
     * @return 格式化后的字符串
     */
    public static String format(int[] ints) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            sb.append(ints[i]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
