package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo3 {

    public static void main(String[] args) {
//        String str = "123456,";
//        int i = str.length() - 1;
//        if(!(str.charAt(i) >= '0' && str.charAt(i) <= '9')){
//            i--;
//        }
//        System.out.println(str.substring(0, i + 1));

        String str = "马牌22555r16，固特异22555r16";
//        ArrayList<String> strings = fetchTireSize(str);
        System.out.println("123，456".contains(","));
        System.out.println(str.replace("，" , " "));
    }


    // [225, 235, 245, 255],[40, 45, 50, 55, 60],[15, 16, 17, 18, 19],"马牌22555r16，固特异22555r16"
    // [225, 235, 245, 255],[40, 45, 50, 55, 60],[15, 16, 17, 18, 19],"马牌225/55r16 马牌22555r17"
    // int[] tw, int[] ta, int[] tr,
    public static ArrayList<String> fetchTireSize (int[] tw, int[] ta, int[] tr, String query) {
        // write code here
        ArrayList<String> list = new ArrayList<>();
        query.replace("，", " ");
        String[] strings = query.split(" ");
        for (String str : strings) {
            int i = str.length() - 1;
            int trr = Integer.parseInt(str.substring(i-1, i+1));
            i -= 2;
            if(str.charAt(i) == 'R' || str.charAt(i) == 'r'){
                i--;
            }
            int taa = Integer.parseInt(str.substring(i-1, i+1));
            i -= 2;
            if(!(str.charAt(i) >= '0' && str.charAt(i) <= '9')){
                i--;
            }
            int tww = Integer.parseInt(str.substring(i-2, i + 1));
            if (isTrue(tw, ta, tr, tww, taa, trr)) {
                StringBuilder s = new StringBuilder();
                s.append(tww+"/");
                s.append(taa + "R");
                s.append(trr);
                list.add(s.toString());
            }
        }

        return list;
    }

    public static boolean isTrue(int[] tw, int[] ta, int[] tr, int tww, int taa, int trr) {
        int flag1 = 0;
        int flag2 = 0;
        int flag3 = 0;
        for (int i : tw) {
            if (i == tww) {
                flag1 = 1;
            }
        }
        for (int i : ta) {
            if (i == taa) {
                flag2 = 1;
            }
        }
        for (int i : tr) {
            if (i == trr) {
                flag3 = 1;
            }
        }

        return (flag1 == 1 && flag2 == 1 && flag3 == 1);
    }

    public String reverse_sentence (String sentence) {
        // write code here
        String[] strings = sentence.split(" ");
        StringBuilder s = new StringBuilder();
        int n = strings.length;
        for (int i = n - 1; i >= 0; i--) {
            s.append(strings[i]);
            if (i != 0) {
                s.append(" ");
            }
        }
        return s.toString();
    }

//    public String carServiceRecommendation (int B, int T) {
//        // write code here
//
//    }

}
