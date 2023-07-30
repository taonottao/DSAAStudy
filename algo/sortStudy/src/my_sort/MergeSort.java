package my_sort;


import java.lang.reflect.WildcardType;

/**
 * 归并排序
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/29 10:08
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12, 15, 4, 9, 51, 18};
        MergeSort.mergeSort(arr);
        System.out.println("***********");
    }

    public static void mergeSort1(int[] arr) {
        mergeSortFunc(arr, 0, arr.length - 1);
    }

    private static void mergeSortFunc(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left+right)/2;
        mergeSortFunc(arr, left, mid);
        mergeSortFunc(arr, mid+1, right);

        merge(arr, left, right, mid);

    }

    private static void merge(int[] arr, int left, int right, int mid) {
        int s1 = left;
        int s2 = mid + 1;
        int[] tmp = new int[right-left+1];
        int k = 0;
        while (s1 <= mid && s2 <= right) {
            if (arr[s1] <= arr[s2]) {
                tmp[k++] = arr[s1++];
            } else {
                tmp[k++] = arr[s2++];
            }
        }

        while (s1 <= mid) {
            tmp[k++] = arr[s1++];
        }
        while (s2 <= right) {
            tmp[k++] = arr[s2++];
        }

        for (int i = 0; i < tmp.length; i++) {
            arr[i + left] = tmp[i];
        }
    }

    /**
     * 非递归实现
     */
    public static void mergeSort(int[] arr) {
        int gap = 1;
        while (gap < arr.length) {
            for (int i = 0; i < arr.length; i += 2*gap) {
                int left = i;
                int mid = left + gap - 1;// 可能会越界
                if (mid >= arr.length) {
                    mid = arr.length - 1;
                }
                int right = mid + gap;
                if (right >= arr.length) {
                    right = arr.length-1;
                }
                merge(arr,left,right,mid);
            }
            gap *= 2;
        }
    }


}
