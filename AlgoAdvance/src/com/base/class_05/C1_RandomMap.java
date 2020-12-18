package com.base.class_05;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class C1_RandomMap {

    private Map<String, Integer> dataMap;
    private Map<Integer, String> indexMap;
    private Integer index;
    
    public C1_RandomMap(){
      dataMap = new HashMap<String, Integer>();
      indexMap = new HashMap<Integer, String>();
      index = Integer.valueOf(0);
    }
    
    public void insert(String key){
      if(dataMap.containsKey(key)){
        return;
      }
      index++;
      indexMap.put(index, key);
      dataMap.put(key, index);
    }
    
    public boolean delete(String key){
      if(null == dataMap.get(key)){
          return false;
      }
      Integer i = dataMap.get(key);
      String lastKey = indexMap.get(index);
      dataMap.remove(key);
      indexMap.remove(index);
      indexMap.put(i, lastKey);
      dataMap.put(lastKey, i);
      index--;   
      return true;
    }
    
    public String getRandom(){
      int i = (int)(new Random().nextDouble() * (index+1));
      return indexMap.get(Integer.valueOf(i));
    }

}
