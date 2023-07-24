package Demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/23 20:48
 */
public class Exer_7_7_2 {
    /**
     * 抄送列表
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String a = in.nextLine();
            String b = in.nextLine();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < a.length(); i++) {
                String str = "";
                if (a.charAt(i) == '"') {
                    i++;
                    while (a.charAt(i) != '"') {
                        str += a.charAt(i);
                        i++;
                    }
                    list.add(str);
                } else {
                    while (i < a.length() && a.charAt(i) != ',') {
                        str += a.charAt(i);
                        i++;
                    }
                    list.add(str);
                }
            }
            if (list.contains(b)) {
                System.out.println("Ignore");
            } else {
                System.out.println("Important!");
            }
        }
    }
}
