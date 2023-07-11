package my_sort;

/**
 * 时间复杂度 N^2
 * 空间复杂度 1
 * 稳定
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/10 16:30
 */
public class InsertSort {

    /**
     * 直接插入排序
     * @param arr
     */
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }else {
                    arr[j+1] = tmp;
                    break;
                }
            }
            arr[j+1] = tmp;
        }
        
    }

    /**
     * 希尔排序
     * 时间复杂度 N^1.3 - N^1.5
     * 空间复杂度 1
     * 不稳定
     * @param arr
     */
    public void shellSort(int[] arr){
        int gap = arr.length;
        while (gap > 1) {
            gap /= 2;
            shell(arr, gap);
        }
    }
    private void shell(int[] arr, int gap){
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - gap;
            for (; j >= 0; j-= gap) {
                if (arr[j] > tmp) {
                    arr[j+gap] = arr[j];
                }else {
                    arr[j+gap] = tmp;
                    break;
                }
            }
            arr[j+gap] = tmp;
        }
    }
}
