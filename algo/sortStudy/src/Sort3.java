import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 快速排序
 *
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/16 22:44
 */
public class Sort3 {

    /**
     * 时间复杂度：N*logN(最好的情况下)
     *           N^2(最坏情况：有序、逆序)
     * 空间复杂度：
     *          最好情况：logN
     *          最坏情况：N
     * 稳定性：不稳定
     * @param arr
     */
    public static void quickSort(int[]  arr){
        quick(arr, 0, arr.length - 1);
    }
    private static void quick(int[] arr, int start, int end){
        //为什么取大于号：1 2 3 4 5 6
        if(start >= end){
            return;
        }

        //使用这个优化，主要解决减少递归的次数
        if(end - start + 1 <= 14){
            //插入排序
            insertSort(arr, start, end);
        }

        //三数取中法
        int index = midThree(arr, start, end);
        swap(arr, index, start);

        int pivot = partition(arr, start, end);//划分

        quick(arr, start, pivot - 1);
        quick(arr, pivot + 1, end);

    }

    private static void insertSort(int[] arr, int left, int right) {

        for (int i = left + 1; i <= right; i++) {

            int tmp = arr[i];
            int j = i - 1;
            for (; j >= left; j--) {

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

    private static int midThree(int[] arr, int left, int right){
        int mid = (left + right) / 2;

        if(arr[left] < arr[right]){

            if(arr[mid] < arr[left]){
                return left;
            }else if(arr[mid] > arr[right]){
                return right;
            }else {
                return mid;
            }
        }else {
            if(arr[mid] > arr[left]){
                return left;
            }else if(arr[mid] < arr[right]){
                return right;
            }else {
                return mid;
            }
        }

    }

    //挖坑法
    private static int partition(int[] arr, int left, int right){
        int tmp = arr[left];
        while (left <right){
            while (left < right && arr[right] >= tmp){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp){
                left++;
            }
            arr[right] = arr[left];

        }
        arr[left] = tmp;
        return left;
    }

    //Hoare法
    private static int partition2(int[] arr, int left, int right){
        int tmp = arr[left];
        int i = left;
        while (left <  right){
            while (left < right && arr[right] >= tmp){
                right--;
            }
            while (left <right && arr[left] <= tmp){
                left++;
            }
            swap(arr, left, right);

        }
        swap(arr, i ,  left);
        return left;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i]  = arr[j];
        arr[j] = tmp;
    }

    /**
     * 非递归实现快速排序
     */
    public static void quickSort1(int[] arr){
        Deque<Integer> stack =  new ArrayDeque<>();
        int left = 0;
        int right = arr.length - 1;
        int pivot = partition(arr, left, right);
        if(pivot >left + 1){
            stack.push(left);
            stack.push(pivot - 1);
        }
        if(pivot < right - 1){
            stack.push(pivot + 1);
            stack.push(right);
        }
        while (!stack.isEmpty()){
            right = stack.pop();
            left = stack.pop();
            pivot = partition(arr, left, right);
            if(pivot >left + 1){
                stack.push(left);
                stack.push(pivot - 1);
            }
            if(pivot < right - 1){
                stack.push(pivot + 1);
                stack.push(right);
            }
        }

    }

}
