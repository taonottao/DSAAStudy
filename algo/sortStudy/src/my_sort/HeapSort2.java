package my_sort;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/24 21:59
 */
public class HeapSort2 {
    public static void main(String[] args) {
        int[] arr = {12, 59, 64, 9, 86, 36};
        heapSort(arr);
        System.out.println();
    }

    public static void heapSort(int[] arr) {
        createBigHeap(arr);
        int end = arr.length - 1;
        while (end >= 0) {
            swap(arr, 0, end);
            shiftDown(arr, 0, end);
            end--;
        }

    }

    private static void createBigHeap(int[] arr) {
        for (int parent = (arr.length - 1 - 1) / 2; parent >= 0; parent--) {
          shiftDown(arr, parent, arr.length);
        }
    }

    private static void shiftDown(int[] arr, int parent, int end) {
        int child = 2 * parent + 1;
        while (child < end) {
            while (child + 1 < end && arr[child] < arr[child + 1]) {
                child++;
            }
            if (arr[child] > arr[parent]) {
                swap(arr, child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i]  = arr[j];
        arr[j] = tmp;
    }

}
