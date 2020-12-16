package com.advence.class_06;

import java.util.HashMap;

/**
 * LFU least Frequency Used
 * 当容量满了，根据操作次数（频率）作为依据,选择性删除空出空间
 * 思想：
 * 一个HashMap 一个二维的双向队列
 * HashMap存储Record
 * Y轴存储同频率的Record，头增尾删
 * X轴存储Y轴，清除Y轴无数据需
 * 
 * 代码编写总结
 * Y轴内容对象Record
 *  key value up down frequency
 * Y轴容器对象FrequencyList
 *  head tail addRecordToHead deleteTailRecord
 * Cache
 *  recordMap存储所有的Record
 *  head X轴双向列表的头部
 *  listOfRecordMap record在哪个Y轴容器
 *  capacity
 *  size
 *  
 *  set get
 *  核心代码
 *  adjust
 *      因frequency++触发Y轴 X轴的变动，注意在head 在tail
 *  modify
 *      因Y轴删除record，导致X轴的变动，注意在head 在tail
 *      
 * @author yucang
 *
 */
interface ILFUCache<K, V> {
    void set(K key, V value);
    V get(K key);
}

interface IFrequencyList<K, V>{
    void addRecordToHead(Record<K, V> record);
    boolean isEmpty();
    void deleteRecord(Record<K, V> record);
}

class Record<K, V>{
    K key;
    V value;
    Record<K, V> up;
    Record<K, V> down;
    int frequency;
    public Record(K key, V value) {
        super();
        this.key = key;
        this.value = value;
        this.up = null;
        this.down = null;
        this.frequency = 1;
    }
}

class FrequencyList<K, V> implements IFrequencyList<K, V>{

    FrequencyList<K, V> prev;
    
    FrequencyList<K, V> next;
    
    Record<K, V> head;
    
    Record<K, V> tail;
    
    public FrequencyList(Record<K, V> record) {
        this.head = record;
        this.tail = record;
    }
    
    @Override
    public void addRecordToHead(Record<K, V> record) {
        this.head.up = record;
        record.down = this.head;
        this.head =record;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void deleteRecord(Record<K, V> record) {
        if(this.head == this.tail) {
            this.head = null;
            this.tail = null;
        }else if(record == this.head) {
            this.head = this.head.down;
            this.head.up = null;
        }else if(record == this.tail) {
            this.tail = this.tail.up;
            this.tail.down = null;
        }else {
            record.up.down = record.down;
            record.down = record.up;
        }
    }
    
}

public class LFU<K, V> implements ILFUCache<K, V>{
    // Save all record
    private HashMap<K, Record<K, V>> recordMap;
    // The reference of the FrequencyList whose frequency is the lowest
    private FrequencyList<K, V> headList;
    // Save what FrequencyList a record belongs to
    private HashMap<Record<K, V>, FrequencyList<K, V>> listOfRecordMap;
    // How many recordMap the LFUCache can contain
    private int capacity;
    // how many recordMap has been saved
    private int size;
    
    public LFU(int capacity) {
        this.recordMap = new HashMap<>();
        this.listOfRecordMap = new HashMap<>();
        this.size = 0;      
        this.headList = null;
        this.capacity = capacity;
    }
    
    @Override
    public void set(K key, V value) {
        if(this.recordMap.containsKey(key)) {
            Record<K, V> record = recordMap.get(key);
            record.value = value;
            record.frequency++;
            adjust(record, this.listOfRecordMap.get(record));
            return;
        }
        
        // 每次因容量满了删除X轴的head的tail
        if(this.size == this.capacity) {
            this.recordMap.remove(headList.tail.key);
            headList.deleteRecord(headList.tail);
            this.size--;
            modifyFrequencyList(this.headList);
        }
        
        Record<K, V> newRecord = new Record<K, V>(key, value);
        recordMap.put(key, newRecord);
        this.size++;
        
        if(this.headList == null) {
            this.headList = new FrequencyList<K, V>(newRecord);
        }else if(this.headList.head.frequency == 1) {
            this.headList.addRecordToHead(newRecord);
        }else {
            FrequencyList<K, V> frequencyList = new FrequencyList<K, V>(newRecord);
            this.headList.prev = frequencyList;
            frequencyList.next = this.headList;
            frequencyList.prev = null;
            this.headList = frequencyList;
            
        }
        listOfRecordMap.put(newRecord, headList);
    }
    @Override
    public V get(K key) {
        if(!recordMap.containsKey(key)) {
            return null;
        }
        Record<K, V> record = recordMap.get(key);
        record.frequency++;
        adjust(record, listOfRecordMap.get(record));
        return record.value;
    }
    
    /**
     * set contain
     * get
     */
    private void adjust(Record<K, V> record, FrequencyList<K, V> frequencyList) {
        frequencyList.deleteRecord(record);
        modifyFrequencyList(frequencyList);
        
        FrequencyList<K, V> prevList = frequencyList.prev;
        FrequencyList<K, V> nextList = frequencyList.next;
        
        if(nextList != null && record.frequency == nextList.head.frequency) {
            nextList.addRecordToHead(record);
            listOfRecordMap.put(record, nextList);
        }else {
            FrequencyList<K, V> newList = new FrequencyList<K, V>(record);
            // 判断newList该放在那个位置,即调整X轴位置
            if(prevList == null) {            // X轴至多一个节点
                if(nextList != null) {
                    nextList.prev = newList;
                }
                newList.next = nextList;
                newList.prev = null;
                this.headList = newList;
            }else if(nextList == null) {      // 在X轴tail位置
                prevList.next = newList;
                newList.prev = prevList;
                nextList.next = null;
            }else {                          
                prevList.next = newList;
                newList.prev = prevList;
                newList.next = nextList;
                nextList.prev = newList;
            }
            listOfRecordMap.put(record, newList);
        }
    }
    
    /**
     * Y轴数据数据量判断，是否为空
     * @param frequencyList
     * @return
     */
    private boolean modifyFrequencyList(FrequencyList<K, V> frequencyList) {
        if(!frequencyList.isEmpty()) {
            return false;
        }
        if(frequencyList.prev == null) { // frequencyList is head
            this.headList = frequencyList.next;
            if(this.headList != null) {
               this.headList.prev = null; 
            }
        }else if(frequencyList.next == null) {// frequencyList is tail
            frequencyList.prev.next = null;
        }else {                               // 
            frequencyList.prev.next = frequencyList.next;
            frequencyList.next.prev = frequencyList.prev;
        }
        return true;
    }
}
