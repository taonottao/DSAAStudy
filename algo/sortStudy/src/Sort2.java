
/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/16 19:58
 */
public class Sort2 {

    /**
     * 堆排序
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param arr
     */
    public static void heapSort(int[] arr){
        createBigHeap(arr);
        int end = arr.length-1;
        while (end > 0){
            swap(arr, 0, end);
            shiftDown(arr, 0, end);
            end--;
        }
    }

    private static void createBigHeap(int[] arr){
        for (int parent = (arr.length - 1 - 1)/2; parent >= 0 ; parent--) {
            shiftDown(arr, parent, arr.length);
        }
    }

    private static void shiftDown(int[] arr, int parent, int len){
        int child = 2*parent + 1;
        while (child < len){
            if(child + 1 < len && arr[child] < arr[child+1]){
                child++;
            }
            if(arr[child] > arr[parent]){
                swap(arr, child,  parent);
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i]  = arr[j];
        arr[j] = tmp;
    }

    /**
     * 冒泡排序
     * 时间复杂度（不考虑优化）：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean flg = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] >arr[j+1]){
                    swap(arr, j, j+1);
                    flg = true;
                }
            }
            if(flg == false){
                return;
            }
        }
    }
}
