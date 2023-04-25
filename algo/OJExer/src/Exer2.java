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
        int mid = 0;
        List<List<Character>> lists = new ArrayList<>();
        for(mid = 1; mid < s.length()- 1; mid++){
            List<Character> list1 = new ArrayList<>();
            List<Character> list2 = new ArrayList<>();
            List<Character> list3 = new ArrayList<>();
            l = mid - 1;
            r = mid + 1;
            while(l >=0 && mid < s.length() && s.charAt(mid) == s.charAt(l)){
                l--;
                mid++;
            }
            for(l = l +1; l < mid; l++){
                list1.add(s.charAt(l));
            }
            lists.add(list1);
            while(mid >=0 && r < s.length() && s.charAt(mid) == s.charAt(r)){
                mid--;
                r++;
            }
            for(mid = mid +1; mid < r; mid++){
                list2.add(s.charAt(mid));
            }
            lists.add(list2);
            while(s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            for(l = l + 1; l < r; l++){
                list3.add(s.charAt(l));
            }
            lists.add(list3);
        }
        int i = 0;
        int max = lists.get(0).size();
        int index = 0;
        for(i = 1; i < lists.size(); i++){
            if(max < lists.get(i).size()){
                max = lists.get(i).size();
                index = i;
            }
        }

        return lists.get(index).toString();
    }


}
