package leetcode.twopointer;

import java.util.Arrays;

/**
 * 有效三角形的个数
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/19 22:14
 */
public class Exer611 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for(int i = n - 1; i >= 2; i--){
            int l = 0;
            int r = i - 1;
            while(l < r){
                if(nums[l] + nums[r] > nums[i]){
                    count += r - l;
                    r--;
                }else{
                    l++;
                }
            }
        }
        return count;
    }
}
