package leetcode.twopointer;

/**
 * 盛最多水的容器
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/8 12:15
 */
public class Exer11 {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int ret = 0;

        while(left < right){
            int v = Math.min(height[left], height[right]) * (right - left);
            ret = Math.max(ret, v);
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return ret;
    }
}
