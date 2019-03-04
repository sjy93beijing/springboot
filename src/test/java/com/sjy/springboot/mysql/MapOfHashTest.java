package com.sjy.springboot.mysql;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * @author sjy on 2018/12/28
 * @version 1.0
 */
public class MapOfHashTest {


    @Test
    public void testJson(){
        HashMap map = new HashMap();
        Random r = new Random();
        map.put("one", r.nextInt(10));
        map.put("two", r.nextInt(10));
        map.put("three", r.nextInt(10));

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()){
            //如果还有下一个，若是第一个则，取出下一个。若到最后一个循环结束
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }

    }

    //map遍历方法
    @Test
    public void testhashMap(){
        int val = 0;
        String key = null;
        Integer value = null;
        Random r = new Random();
        HashMap map = new HashMap();
        for (int i = 0; i < 12 ; i++) {
            val = r.nextInt(100);
            key = String.valueOf(val);
            map.put(key,val);
//            System.out.println("key:"+key+"value:"+val);
        }
//        (01) 通过entrySet()去遍历key、value，参考实现函数：
        iteratorHashMapByEntryset(map);
        iteratorHashMapByKeyset(map);
    }

    private void iteratorHashMapByKeyset(HashMap map) {
        if (map == null)
            return;
        String key = null;
        Integer integ = null;
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            key = (String) iterator.next();
            integ = (Integer) map.get(key);
            System.out.println(key+"--"+integ);

        }

    }

    /**
     * 通过entry Set遍历HashMap
     * @param map
     */
    private void iteratorHashMapByEntryset(HashMap map) {
        if (map == null)
            return;
        System.out.println();
        String key = null;
        Integer inte = null;
        //迭代器
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            key = (String) entry.getKey();
            inte = (Integer) entry.getValue();
            System.out.println(key+"--"+inte.intValue());

        }

    }
}