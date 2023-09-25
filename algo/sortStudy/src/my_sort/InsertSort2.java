package my_sort;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/24 23:34
 */
public class InsertSort2 {
    public static void main(String[] args) {
        int[] arr = {12, 59, 64, 9, 86, 36};
        insertSort(arr);
        System.out.println();
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int tmp = arr[i];
            for (; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }

}
