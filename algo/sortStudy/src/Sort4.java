/**
 * 归并排序
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/18 15:08
 */
public class Sort4 {

    /**
     * 时间复杂度 ：NlogN
     * 空间复杂度 ：O(N)
     * 稳定性：稳定(插排、冒泡、归并)
     * @param arr
     */
    public static void mergeSort(int[] arr){
        mergeSortFunc(arr, 0, arr.length - 1);
    }

    private static void mergeSortFunc(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        int mid = (left + right) / 2;
        mergeSortFunc(arr, left, mid);
        mergeSortFunc(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }

    private static void merge(int[] arr, int  start, int end, int mid){
        int s1 = start;
//        int e1 = mid;
        int s2 = mid + 1;
//        int e2 = end;
        int[] tmp = new int[end - start + 1];
        int k = 0;
        while (s1 <= mid && s2 <= end){
            if(arr[s1] <= arr[s2]){
                tmp[k++] = arr[s1++];
            }else {
                tmp[k++] = arr[s2++];
            }
        }
        while (s1 <= mid){
            tmp[k++] = arr[s1++];
        }
        while (s2 <= end){
            tmp[k++] = arr[s2++];
        }

        for (int i = 0; i < tmp.length; i++) {
            arr[i + start] = tmp[i];
        }
    }

    /**
     * 非递归方式实现归并排序
     * @param arr
     */
    public static void mergeSort1(int[] arr){
        //每组gap个
        int gap = 1;
        while (gap < arr.length){
            //
            for (int i = 0; i < arr.length; i += 2*gap) {
                int left = i;
                int mid = left +gap - 1;//可能越界
                if(mid >= arr.length){
                    mid = arr.length - 1;
                }
                int right = mid  + gap;//可能越界
                if(right >= arr.length){
                    right =  arr.length - 1;
                }
                merge(arr, left, right, mid);
            }

            gap *= 2;
        }
    }

}
