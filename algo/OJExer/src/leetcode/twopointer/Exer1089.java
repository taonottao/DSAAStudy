package leetcode.twopointer;

/**
 * 复写零
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/6 11:17
 */
public class Exer1089 {
    public void duplicateZeros(int[] arr) {
        int cur = 0, dest = -1, n = arr.length;
        while(cur < n){
            if(arr[cur] == 0) dest += 2;
            else dest++;
            if(dest >= n - 1) break;
            cur++;
        }
        if(dest == n){
            arr[n-1] = 0;
            dest -= 2;
            cur--;
        }
        while(cur >= 0){
            if(arr[cur] != 0){
                arr[dest--] = arr[cur--];
            }else{
                arr[dest--] = 0;
                arr[dest--] = 0;
                cur--;
            }
        }
    }
}
