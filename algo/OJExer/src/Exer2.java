import org.junit.Test;

import java.util.*;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/23 22:31
 */
public class Exer2 {

    @Test
    public void test1(){
        String s1 = "abcd";
        String t1 = "accbaadcfd";
        System.out.println(isSubsequence(s1, t1));

        String s2 = "abcdg";
        String t2 = "accbaadcfd";
        System.out.println(isSubsequence(s2, t2));
    }
    /**
     * 判断字符串s是不是字符串t的子序列，即字符串t删掉（或不删）一些字符后能否等于s
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t){
        int lenS = s.length();
        int lenT = t.length();
        int i = 0;//遍历s
        int j = 0;//遍历t
        while (i < lenS && j < lenT){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else {
                j++;
            }
        }

//        if(i >= lenS && j >= lenT){
//            return true;
//        }
//        return false;
        return i  == lenS;
    }

    public static void main1(String[] args) {
        /*
        消除字符串中相邻的相同的字符
         */
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str = in.nextLine();
            Stack<Character> stack = new Stack<>();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(stack.isEmpty() || stack.peek() != ch){
                    stack.push(ch);
                }else {
                    stack.pop();
                }
            }
            //此时栈中的数据就是我们需要的数据，但是为逆序
            if(stack.isEmpty()){
                System.out.println(0);
                return;
            }else {
                while (!stack.isEmpty()){
                    list.add(stack.pop());
                }
                Collections.reverse(list);
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i));
                }
                return;
            }
        }
    }
    public static void main(String[] args) {
        /*
        消除字符串中相邻的相同的字符
         */
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str = in.nextLine();
            StringBuilder stringBuilder = new StringBuilder(str.length());
            int index = -1;
            for (int i = 0; i < str.length(); i++) {
                char ch  = str.charAt(i);
                if(index == -1 ||  ch != stringBuilder.charAt(index)){
                    stringBuilder.append(ch);
                    index++;
                }else {
                    stringBuilder.deleteCharAt(index);
                    index--;
                }
            }
            if(index == -1){
                System.out.println(0);
            }else {
                System.out.println(stringBuilder);
            }
        }
    }

    @Test
    public void test2(){
        String str = "babad";
        String s = longestPalindrome(str);
        System.out.println(s);
    }
    /**
     * 找出最大回文字符串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s == null){
            return s;
        }
        int l  = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++) {//i为中心位置
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i + 1);
            int max = Math.max(len1, len2);

            // 计算对应最大回文子串的起点和终点
            if(max > r - l){
                l = i - (max - 1)/2;
                r = i + max/2;
            }
        }

        return s.substring(l, r + 1);

    }
    public int expandCenter(String s,int left,int right){
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        // 跳出循环的时候恰好满足 s.charAt(left) ！= s.charAt(right)
        while (left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // 回文串的长度是right-left+1-2 = right - left - 1
        return right - left - 1;
    }

    @Test
    public void test3(){
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
        System.out.println(expandCenter(s, 2, 2));
    }




}
