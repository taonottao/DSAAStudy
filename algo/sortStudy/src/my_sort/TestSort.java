package my_sort;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/10 16:31
 */
public class TestSort {
    public static void main(String[] args) {
        int[] arr = {12,56,32,67,10,19,4};
        InsertSort insertSort = new InsertSort();
//        insertSort.insertSort(arr);
        insertSort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
