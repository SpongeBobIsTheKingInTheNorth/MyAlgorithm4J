package com.liy.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LFU淘汰策略的实现。 Least frequently used
 * 超过容量时，删除最少被使用的数据，时间复杂度O(1)
 * @author liyang
 */
public class LFUCache {

    /** key-val key和对应val的缓存 */
    private Map<String, Integer> keyToVal;

    /** key-freq key和对应使用频率的缓存 */
    private Map<String, Integer> keyToFreq;

    /** 每个使用频率下对应的key集合。key集合中最前端 */
    private Map<Integer, LinkedHashSet<String>> freqToKeys;

    /** 缓存容量 */
    private int capacity;

    /** 当前最小的访问频率 */
    private int minFreq;

    private int get(String key) {
        // 判断key是否存在
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // 更新访问频率
        incFreq(key);
        // 返回val
        return keyToVal.get(key);
    }

    private void put(String key, int val) {
        if (keyToVal.containsKey(key)) {
            // 存在，更新val和freq
            keyToVal.put(key, val);
            incFreq(key);
            return;
        }
        // 不存在时，判断是否超过capacity, 不超过这添加并更新freq， 超过则删除LFU
        if (keyToVal.size() >= capacity) {
            // 删除LFU
            removeLeastFrequent();
        }
        // 添加key
        keyToVal.put(key, val);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        // 更新freq
        minFreq = 1;
    }

    /**
     * 增加key对应的访问频率
     * @param key key
     */
    private void incFreq(String key) {
        int freq = keyToFreq.get(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
        }
    }

    /**
     * 删除最后使用的key
     */
    private void removeLeastFrequent() {
        Iterator<String> keys = freqToKeys.get(minFreq).iterator();
        String key = keys.next();
        keys.remove();
        if (!keys.hasNext()) {
            // 已清空
            freqToKeys.remove(minFreq);
        }
        keyToVal.remove(key);
        keyToFreq.remove(key);
    }

    /**
     * 构造方法
     * @param capacity 容量
     */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    // 用于debug
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(5);
        cache.put("first", 1);
        cache.put("second", 2);
        cache.put("third", 3);
        cache.put("fourth", 4);
        cache.put("fifth", 5);
        System.out.println("put了5个元素======================");
        cache.printCache(cache);
        cache.get("first");
        System.out.println("访问了first======================");
        cache.printCache(cache);
        cache.get("third");
        System.out.println("访问量third======================");
        cache.printCache(cache);
        cache.put("sixth", 6);
        System.out.println("put了sixth======================");
        cache.printCache(cache);
    }

    private void printCache(LFUCache cache) {
        System.out.println("keyToVal:" + cache.getKeyToVal());
        System.out.println("keyToFreq:" + cache.getKeyToFreq());
        System.out.println("freqToKeys:" + cache.getFreqToKeys());
        System.out.println("minFreq:" + cache.getMinFreq());
        System.out.println("capacity:" + cache.getCapacity());
    }

    public Map<String, Integer> getKeyToVal() {
        return keyToVal;
    }

    public void setKeyToVal(Map<String, Integer> keyToVal) {
        this.keyToVal = keyToVal;
    }

    public Map<String, Integer> getKeyToFreq() {
        return keyToFreq;
    }

    public void setKeyToFreq(Map<String, Integer> keyToFreq) {
        this.keyToFreq = keyToFreq;
    }

    public Map<Integer, LinkedHashSet<String>> getFreqToKeys() {
        return freqToKeys;
    }

    public void setFreqToKeys(Map<Integer, LinkedHashSet<String>> freqToKeys) {
        this.freqToKeys = freqToKeys;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMinFreq() {
        return minFreq;
    }

    public void setMinFreq(int minFreq) {
        this.minFreq = minFreq;
    }
}
