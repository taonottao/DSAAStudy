package my_sort;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/11 14:39
 */
public class SelectSort {
    /**
     * 直接选择排序
     * 时间复杂度 N^2
     * 空间复杂度 1
     * 不稳定
     * @param arr
     */
    public void selectSort(int[] arr) {
        if(arr == null || arr.length <= 1) return;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int min = arr[i];
            int minIndex = i;
            while (j < arr.length) {
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
                j++;
            }
                swap(arr, i, minIndex);

        }
    }

    public void selectSort2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = left;
            for (int i = left + 1; i <= right ; i++) {
                if (arr[minIndex] > arr[i]) {
                    minIndex = i;
                }
                if (arr[maxIndex] < arr[i]) {
                    maxIndex = i;
                }
            }
            swap(arr, left, minIndex);
            if (maxIndex == left) {
                maxIndex = minIndex;
            }
            swap(arr, right, maxIndex);
            left++;
            right--;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
