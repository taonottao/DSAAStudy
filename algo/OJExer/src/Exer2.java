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


}
