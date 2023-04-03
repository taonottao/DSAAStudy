package com.attao.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/3 20:42
 */
public class TestDemo {

    @Test
    public void test1(){
        List<List<Integer>> generate = generate(5);
        Iterator<List<Integer>> iterator = generate.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public List<List<Integer>> generate(int row){
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> subret = new ArrayList<>();
        subret.add(1);
        ret.add(subret);
        for (int i = 1; i < row; i++) {
            List<Integer> preList = new ArrayList<>();
            List<Integer> curList =  ret.get(i - 1);
            preList.add(1);
            for (int j = 1; j < i; j++){
                int tmp = curList.get(j) + curList.get(j - 1);
                preList.add(tmp);
            }
            preList.add(1);
            ret.add(preList);
        }
        return ret;
    }
}
