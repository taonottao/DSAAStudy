/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/13 13:22
 */
public class Exer12 {
    /*
    青蛙跳台阶
     */
    public int jumpFloor(int target) {
        if(target <= 1){
            return 1;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    public int[] arr = new int[50];

    public int jumpFloor2(int target) {
        if(target <= 1){
            return 1;
        }
        if(arr[target] > 0){
            return arr[target];
        }
        return arr[target] = (jumpFloor2(target-1) + jumpFloor2(target - 2));
    }

    public int jumpFloor3(int target) {
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= target ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[target];
    }

    public int jumpFloor4(int target) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= target ; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
