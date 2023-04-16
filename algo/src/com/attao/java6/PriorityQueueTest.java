package com.attao.java6;

import org.junit.Test;

import java.util.*;

/**
 * 优先级队列
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/16 9:34
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(10);
        priorityQueue.offer(2);
        //默认为小根堆
        System.out.println(priorityQueue.peek());

        Queue<Student> priorityQueue1 = new PriorityQueue<>();
        priorityQueue1.offer(new Student("张三", 13));
        priorityQueue1.offer(new Student("李四", 23));
        //不能插入null
//        priorityQueue1.offer(null);

    }

    @Test
    public void test1(){
        int[] arr = {1,5,77,33,99,56,231};
        int[] ret = MaxK(arr, 3);
        System.out.println(Arrays.toString(ret));
    }
    //取一组数据中前k个最小元素
    //O(Nlog(N))
    //效率不高
    public int[] smallestK(int[] arr, int k){
        int[] ret = new int[k];
        if(arr == null || k == 0){
            return ret;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(arr.length);

        for(int x : arr){
            minHeap.offer(x);
        }

        for (int i = 0; i < k; i++) {
            ret[i] = minHeap.poll();
        }

        return ret;
    }

    /**
     * 前k个最大元素
     * @param arr
     * @param k
     * @return
     * O(Nlog(k))
     */
    //效率高
    public int[] MaxK(int[] arr, int k){
        int[] ret =  new int[k];
        if(arr == null || k == 0){
            return ret;
        }

        Queue<Integer> minHeap = new PriorityQueue<>(k);
        //1.遍历数组的前k个元素，放到堆中
        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }

        //2.遍历剩下的arr.length-k个，每次和堆顶元素进行比较
        for(int i = k; i < arr.length; i++){
            if(minHeap.peek() < arr[i]){
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = minHeap.poll();
        }

        return ret;
    }

    @Test
    public void test2(){
        Student stu1 = new Student("张三", 10);
        Student stu2 = new Student("张三", 20);
//        Student stu2 = new Student("李四", 10);

        System.out.println(stu1 == stu2);
        System.out.println(stu1.equals(stu2));
        System.out.println(stu1.compareTo(stu2));

        NameComparator nameComparator = new NameComparator();
        int ret = nameComparator.compare(stu1, stu2);
        System.out.println(ret);
    }

    @Test
    public void test3(){
        Queue<Student> priorityQueue1 = new PriorityQueue<>();
        priorityQueue1.offer(new Student("张三", 13));
        priorityQueue1.offer(new Student("李四", 23));

        System.out.println();

        //方式一：
//        Incmp incmp = new Incmp();
//        Queue<Integer> priorityQueue2 = new PriorityQueue<>(incmp);
        //方式二：
//        Queue<Integer> priorityQueue2 = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
        //方式三：
        Queue<Integer> priorityQueue2 = new PriorityQueue<>
                ((o1, o2) -> {return o2.compareTo(o1);});//lambda表达式
        priorityQueue2.offer(1);
        priorityQueue2.offer(2);
        System.out.println();
    }
}

class Incmp implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}

class Student implements Comparable<Student> {
    public int age;
    public String name;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Student o) {
        //小根堆
//        return this.age - o.age;
        //大根堆
        return o.age - this.age;
    }
}

class NameComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}