package exam;


public class Demo5 {

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int tmp = arr[left];
            while (i < j) {
                while (i < j && arr[j] >= tmp) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                }
                while (i < j && arr[i] <= tmp) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                }
            }
            arr[i] = tmp;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr,  left,  right,  mid);
    }

    private void merge(int[] arr, int left, int right, int mid) {
        int s1 = left;
        int s2 = mid + 1;
        int[] tmp = new int[right-left+1];
        int k = 0;
        while(s1 <= mid && s2 <= right){
            if(arr[s1] <= arr[s2]){
                tmp[k] = arr[s1];
                k++;
                s1++;
            } else {
                tmp[k] = arr[s2];
                k++;
                s2++;
            }
        }
        while(s1 <= mid){
            tmp[k++] = arr[s1++];
        }
        while(s2 <= right){
            tmp[k++] = arr[s2++];
        }
        for(int i = 0; i < k; i++){
            arr[i+left] = tmp[i];
        }
    }

    public void createBigHeap(int[] arr){
        for(int parent = (arr.length - 1 - 1) / 2; parent >= 0; parent--){
            shiftDown(arr, parent, arr.length);
        }
    }

    public void shiftDown(int[] arr, int parent, int len){
        int child = 2 * parent + 1;
        while(child < len){
            if(child + 1 < len && arr[child] < arr[child+1]){
                child++;
            }
            if(arr[child] > arr[parent]){
                swap(arr, parent, child);
                parent = child;
                child = 2 * parent + 1;
            }else{
                break;
            }
        }
    }

    public void swap(int[] arr, int x, int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

}
