package session_6;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 extends LinkedHashMap<Integer,Integer> {
    private int capacity;
    public LRUCache2(int capacity){
        super(capacity, 0.75F, true);
        this.capacity=capacity;
    }
    public void put(int key,int value){
        super.put(key,value);
}
    public int get(int key){return super.getOrDefault(key,-1);}

    @Override // when capacity is full remove eldest
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size()>capacity;
    }

}