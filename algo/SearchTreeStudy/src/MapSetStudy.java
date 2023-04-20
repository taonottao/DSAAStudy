import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/20 19:38
 */

class Student{

}

public class MapSetStudy {

    @Test
    public void test4(){
//        String str = "loveleetcode";
        String str = "aabb";
        int i = 0;
        int[] arr = new int[26];
        for (i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }

        for (i = 0; i < str.length(); i++) {
            if(arr[str.charAt(i) - 'a'] == 1){
                System.out.println(i);
                break;
            }
        }
        if(i >= str.length()){
            System.out.println(-1);
        }
    }

    @Test
    public void test3(){
        Set<String> set = new TreeSet<>();
        set.add("hello");
        set.add("abc");
        set.add("the");
        System.out.println(set);
    }

    @Test
    public void test2(){
        Map<Student, Integer> treeMap = new TreeMap<>();
        //key必须是可以比较的
        treeMap.put(new Student(), 1);
        treeMap.put(new Student(), 4);
        System.out.println(treeMap);
    }

    @Test
    public void test1(){
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("hello", 3);
        treeMap.put("abc", 4);
        treeMap.put("the", 8);
        treeMap.put("the", 18);
        System.out.println(treeMap);
        Integer val = treeMap.get("hello");
        System.out.println(val);
        Integer val1 = treeMap.getOrDefault("hello2", 100);
        System.out.println(val1);
        Set<String> keySet = treeMap.keySet();
        System.out.println(keySet);
        System.out.println("**********************");
        Set<Map.Entry<String, Integer>> set = treeMap.entrySet();
        for(Map.Entry<String, Integer> entry : set){
            System.out.println("key: " +entry.getKey() + " value: " + entry.getValue());
        }
    }

}
