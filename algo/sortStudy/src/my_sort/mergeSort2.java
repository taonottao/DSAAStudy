package my_sort;

import com.sun.media.sound.MidiOutDeviceProvider;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/24 22:26
 */
public class mergeSort2 {
    public static void main(String[] args) {
        int[] arr = {12, 59, 64, 9, 86, 36};
        mergeSort(arr);
        System.out.println();
    }

    public static void mergeSort(int[] arr) {
        mergeSortFunc(arr, 0, arr.length - 1);
    }

    private static void mergeSortFunc(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortFunc(arr, left, mid);
        mergeSortFunc(arr, mid + 1, right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int left, int right) {
        int[] tmp = new int[right - left + 1];
        int mid = (left + right) / 2;
        int s1 = left;
        int s2 = mid + 1;
        int k = 0;
        while (s1 <= mid && s2 <= right) {
            if (arr[s1] > arr[s2]) {
                tmp[k++] = arr[s2];
                s2++;
            } else {
                tmp[k++] = arr[s1];
                s1++;
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

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
