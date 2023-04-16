/**
 *
 * 插入排序：1.直接插入排序
 *          2.希尔排序
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/16 16:36
 */
public class Sort {

    /**
     * 直接插入排序
     *
     * 时间复杂度：O(n^2)
     *      最好的情况下：O(n)
     *             当数据趋于有序的情况下，排序速度会非常快
     *                  一般的场景就是数据基本有序，建议使用直接插入排序
     * 空间复杂度:O(1)
     * 稳定性：稳定
     *        如果一个排序是稳定的，那么就可以实现为不稳定的
     *        但是如果一个排序是不稳定的，没有办法时限为稳定的排序
     * @param arr
     */
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {

            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {

                if(arr[j] > tmp){
                    arr[j + 1] = arr[j];
                }else {
//                    arr[j + 1] = tmp;
                    break;
                }

            }
            arr[j + 1] = tmp;

        }
    }

    /**
     * 希尔排序
     * 时间复杂度：O(N^1.3) - O(N^1.5)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param arr
     */
    public static void shellSort(int[] arr){
        int gap = arr.length;
        while (gap > 1){
            shell(arr, gap);
            gap /= 2;
        }
        shell(arr, 1);
    }

    public static void shell(int[] arr, int gap){
        for (int i = gap; i < arr.length; i++) {

            int tmp = arr[i];
            int j = i - gap;
            for (; j >= 0; j-=gap) {

                if(arr[j] > tmp){
                    arr[j + gap] = arr[j];
                }else {
                    break;
                }

            }
            arr[j + gap] = tmp;

        }
    }
}
