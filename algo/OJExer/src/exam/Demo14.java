package exam;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/10 15:04
 */
public class Demo14 {


    public static List<Integer> findPrimeNumbers(int n){
        List<Integer> list = new ArrayList<>();

        for(int i = 2; i <= n; i++){
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }

    public static String twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target) {
                    String ret = "Indices: " + i + ", " + j;
                    return ret;
                }
            }
        }
        return "No two sum solution";
    }

    public static String maxLen(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        int max = 1;
        int maxI = 0;
        int maxJ = 0;
        for(int i = n - 2; i >= 0; i++){
            dp[i][i] = 1;
            for(int j = i + 1; j < n; j++){
                if(str.charAt(i) == str.charAt(j)){
                    if (i + 1 < j) {
                        if (dp[i + 1][j - 1] > 0) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        }
                    }else {
                        dp[i][j] = 2;
                    }

                    if (max < dp[i][j]) {
                        max = dp[i][j];
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        return str.substring(maxI, maxJ + 1);
    }
}
