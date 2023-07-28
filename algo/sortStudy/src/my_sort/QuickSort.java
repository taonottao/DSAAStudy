package my_sort;

import com.sun.xml.internal.bind.v2.model.runtime.RuntimeLeafInfo;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/27 20:36
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12,15,4,9,51,18};
        QuickSort.quickSort1(arr);
        System.out.println("***********");
    }

    /**
     * 挖坑法
     */
    public static void quickSort1(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        quick1(arr, left, right);
    }

    public static void quick1(int[] arr,int left, int right) {

        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        quick1(arr, left, pivot - 1);
        quick1(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int tmp = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

}
