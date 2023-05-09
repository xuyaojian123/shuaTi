package xyj.P146LRU»º´æ;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    int capacity;
    Map<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)){
            makeRecently(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)){
            cache.put(key,value);
            makeRecently(key);
        }else {
            if (cache.size() >= capacity){
                int next = cache.keySet().iterator().next();
                cache.remove(next);
            }
            cache.put(key,value);
        }
    }

    public void makeRecently(int key){
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key,value);
    }
}
