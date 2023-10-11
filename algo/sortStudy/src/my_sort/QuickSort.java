package my_sort;

import com.sun.xml.internal.bind.v2.model.runtime.RuntimeLeafInfo;

import java.util.Stack;
import java.util.logging.Level;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/27 20:36
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12, 15, 4, 9, 51, 18};
        QuickSort.quickSort(arr);
        System.out.println("***********");
    }

    /**
     * 挖坑法
     */
    public static void quickSort1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        quick1(arr, left, right);
//        quick2(arr, left, right);
    }

    public static void quick1(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        if (right - left + 1 <= 14) {
            // 插入排序
            insertSort(arr, left, right);
        }

        // 三数取中法
        int index = midThree(arr, left, right);
        swap(arr, left, index);

        int pivot = partition1(arr, left, right);
        quick1(arr, left, pivot - 1);
        quick1(arr, pivot + 1, right);
    }

    public static int partition1(int[] arr, int left, int right) {
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

    /**
     * Hoare法
     */
    public static void quick2(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int pivot = partition2(arr, left, right);
        quick2(arr, left, pivot - 1);
        quick2(arr, pivot + 1, right);
    }

    public static int partition2(int[] arr, int left, int right) {
        int tmp = arr[left];
        int i = left;
        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, left, i);
        return left;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int midThree(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] < arr[right]) {
            if (arr[mid] < arr[left]) {
                return left;
            } else if (arr[mid] > arr[right]) {
                return right;
            } else {
                return mid;
            }
        } else {
            if (arr[mid] > arr[left]) {
                return left;
            } else if (arr[mid] < arr[right]) {
                return right;
            } else {
                return mid;
            }
        }
    }

    public static void insertSort(int[] arr, int left, int right) {

        for (int i = left + 1; i <= right; i++) {
            int tmp = arr[i];
            int j = i - 1;
            //2  1
            for (; j >= left; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    arr[j + 1] = tmp;
                    break;
                }
            }
            arr[j + 1] = tmp;
        }

    }

    /**
     * 非递归实现快排
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = arr.length - 1;
        int pivot = partition1(arr, left, right);

        if (pivot > left + 1) {
            stack.push(left);
            stack.push(pivot - 1);
        }
        if (pivot < right - 1) {
            stack.push(pivot + 1);
            stack.push(right);
        }

        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            pivot = partition1(arr, left, right);
            if (pivot > left + 1) {
                stack.push(left);
                stack.push(pivot - 1);
            }
            if (pivot < right - 1) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }

}
