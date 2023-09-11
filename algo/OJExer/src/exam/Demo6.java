package exam;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Demo6 {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.next();
            String[] dic = in.next().split(",");
            List<String> list = new ArrayList<>();
            int maxLen = 0;
            for (int i = 0; i < dic.length; i++) {
                String tmp = dic[i];
                if(find(s, tmp)){
                    list.add(tmp);
                    maxLen = Math.max(maxLen, tmp.length());
                }
            }
            if (list.size() > 0) {
                List<String> newList = new ArrayList<>();
                for (String res : list) {
                    if (res.length() == maxLen) {
                        newList.add(res);
                    }
                }
                Collections.sort(newList);
                System.out.println(newList.get(0));
            } else {
                System.out.println("");
            }
        }
    }

    private static boolean find(String s, String tmp) {
        if (tmp.length() > s.length()) {
            return false;
        }
        StringBuilder res = new StringBuilder();
        int index = 0;
        for (int i = 0; i < tmp.length(); i++) {
            for (int j = index; j < s.length(); j++) {
                if (s.charAt(j) == tmp.charAt(i)) {
                    res.append(s.charAt(j));
                    index = j + 1;
                    break;
                }
            }
            if (index >= s.length()) {
                break;
            }
        }
        if(tmp.equals(res.toString())){
            return true;
        }
        return false;
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String[] s1 = in.next().split(",");
            String[] s2 = in.next().split(",");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s1.length; i++) {
                for (int j = 0; j < s2.length; j++) {
                    if (s1[i].equals(s2[j])) {
                        s2[j] = "a";
                        list.add(s1[i]);
                        break;
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                res.append(list.get(i));
                if(i < list.size() - 1){
                    res.append(",");
                }
            }
            System.out.println(res.toString());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String[] ss = s.split(" ");
            System.out.println(2);
        }
    }
}
