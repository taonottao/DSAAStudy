package Demo2;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/22 18:55
 */
public class Exer_7_5_1 {
    /**
     * 剪花布条
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            String t = in.next();
            int ans = cut(s, t);
            System.out.println(ans);
        }
    }

    private static int cut(String s, String t) {
        int i = s.indexOf(t);
        if(i == -1){
            return 0;
        }else {
            s = s.substring(i+t.length(), s.length());
            return 1 + cut(s, t);
        }
    }
}
