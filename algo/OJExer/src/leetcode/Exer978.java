package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 最长湍流子数组
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/28 12:26
 */
public class Exer978 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            Deque<String> stack = new LinkedList<>();
            for(int i = 0; i <str.length(); i++){
                char ch = str.charAt(i);
                if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')){
                    int left= i;
                    int right = i;
                    while(i < str.length() && (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')){
                        right++;
                        i++;
                        if(i < str.length()){
                            ch = str.charAt(i);
                        }else {
                            break;
                        }
                    }
                    String subStr = str.substring(left, right);
                    stack.push(subStr);
                    i--;
                }else{
                    if(!stack.peek().equals(" ")){
                        stack.push(" ");
                    }
                }
            }
            while(!stack.isEmpty()){
                System.out.print(stack.pop());
            }
            System.out.println();
        }
    }
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int[] f = new int[n];
        int[] g = new int[n];

        for(int i = 0; i < n; i++){
            f[i] = g[i] = 1;
        }
        int max = 1;
        for(int i = 1; i < n; i++){
            if(arr[i-1] < arr[i]){
                f[i] = g[i-1] + 1;
            } else if(arr[i-1] > arr[i]){
                g[i] = f[i-1] + 1;
            }
            max = Math.max(max, Math.max(f[i], g[i]));
        }

        return max;
    }
}
