/**
 * 选择排序
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/16 18:38
 */
public class Sort1 {

    /**
     * 选择排序
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param arr
     */
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);

        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i]  = arr[j];
        arr[j] = tmp;
    }

    public static void selectSort1(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            int minIndex = left;
            int maxIndex = left;
            for (int i = left + 1; i <= right; i++) {
                if(arr[i] < arr[minIndex]){
                    minIndex = i;
                }
                if(arr[i] > arr[maxIndex]){
                    maxIndex = i;
                }
            }

            swap(arr, minIndex, left);//这里有可能把最大值换到minIndex位置
            if(maxIndex == left){//最大值正好在left的位置
                maxIndex = minIndex;
            }
            swap(arr, maxIndex, right);

            left++;
            right--;
        }
    }
}
