package leetcode.twopointer;

/**
 * 快乐数
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/8 10:25
 */
public class Exer202 {
    public boolean isHappy(int n) {
        int slow = n, fast = bitSum(n);

        while(slow != fast){
            slow = bitSum(slow);
            fast = bitSum(bitSum(fast));
        }
        return slow == 1;
    }

    public int bitSum(int n){
        int sum = 0;
        while(n > 0){
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}
