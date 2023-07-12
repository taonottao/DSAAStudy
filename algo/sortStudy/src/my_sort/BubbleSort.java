package my_sort;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/11 16:12
 */
public class BubbleSort {

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, j+1, j);
                }
            }
            if (flag == false) {
                return;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
