import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/16 16:36
 */
public class SortTest {

    @Test
    public void test1(){
        int[] arr = {12,56,32,67,10,19,4};
        Sort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void initArrayOrder(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
//            arr[i] = arr.length - i;
        }
    }

    public void initArrayNotOrder(int[] arr){
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10_0000);
        }
    }

    public static void testInsertSort(int[] arr){
        arr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.insertSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("直接插入排序耗时:" + (endTime - startTime));
    }

    @Test
    public void test2(){
        int[] arr = new int[10_0000];
        initArrayOrder(arr);
//        initArrayNotOrder(arr);
        testInsertSort(arr);

        testShellSort(arr);

        testInsertSort(arr);

        testSelectSort(arr);

        testHeapSort(arr);

        testQuickSort(arr);//有可能栈溢出异常
    }

    public static void testShellSort(int[] arr){
        arr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort.shellSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序耗时:" + (endTime - startTime));
    }

    @Test
    public void test3(){
        int[] arr = {12,56,32,67,10,19,4};
        Sort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void testSelectSort(int[] arr){
        arr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort1.selectSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序耗时:" + (endTime - startTime));
    }
    public static void testHeapSort(int[] arr){
        arr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort2.heapSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序耗时:" + (endTime - startTime));
    }
    public static void testQuickSort(int[] arr){
        arr = Arrays.copyOf(arr, arr.length);
        long startTime = System.currentTimeMillis();
        Sort3.quickSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序耗时:" + (endTime - startTime));
    }

    @Test
    public void test4(){
        int[] arr = {12,56,32,67,10,19,4};
//        Sort1.selectSort(arr);
        Sort1.selectSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test5(){
        int[] arr = {12,56,32,67,10,19,4};
//        Sort1.selectSort(arr);
//        Sort2.heapSort(arr);
//        Sort2.bubbleSort(arr);
//        Sort3.quickSort1(arr);
        Sort4.mergeSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

}
