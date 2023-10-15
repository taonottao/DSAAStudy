package exam;


import java.util.*;

public class Demo19 {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            for (int i = 0; i < n; i++) {
                List<String> list = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    list.add(in.nextLine());
                }
                char[][] ch = new char[3][3];
                for (int j = 0; j < 3; j++) {
                    ch[j] = list.get(j).toCharArray();
                }
                String ret = judge(ch);
                System.out.println(ret);
            }
        }
    }

    public static String judge(char[][] ch) {
        int flag1 = 0;
        int flag2 = 0;
        for (int i = 0; i < 3; i++) {
            if (ch[i][0] == 'o' && ch[i][1] == '*' && ch[i][2] == 'o') {
                flag1 = 1;
            } else if (ch[i][0] == '*' && ch[i][1] == 'o' && ch[i][2] == '*') {
                flag2 = 1;
            }
            if (ch[0][i] == 'o' && ch[1][i] == '*' && ch[2][i] == 'o') {
                flag1 = 1;
            } else if (ch[0][i] == '*' && ch[1][i] == 'o' && ch[2][i] == '*') {
                flag2 = 1;
            }
        }
        if (flag1 == flag2) {
            return "draw";
        } else if (flag1 == 1) {
            return "yukari";
        } else {
            return "kou";
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String tmp = in.nextLine();
            int n = Integer.parseInt(tmp.split(" ")[0]);
            int m = Integer.parseInt(tmp.split(" ")[1]);
            List<String> role = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                role.add(in.nextLine());
            }
            boolean[] isDead = new boolean[n];

            for (int i = 0; i < m; i++) {
                String[] strs = in.nextLine().split(" ");
                int p1 = Integer.parseInt(strs[0]);
                int p2 = Integer.parseInt(strs[1]);
                String r1 = role.get(p1-1).split(" ")[0];
                String r2 = role.get(p2-1).split(" ")[0];
                if (r1.equals(r2)) {
                    continue;
                } else {
                    int s1 = Integer.parseInt(role.get(p1-1).split(" ")[1]);
                    int s2 = Integer.parseInt(role.get(p2-1).split(" ")[1]);
                    if (r1.equals("human") && strs[2].equals("Y")) {
                        if (s1 > s2) {
                            isDead[p2 - 1] = true;
                        } else if (s1 == s2) {
                            isDead[p1 - 1] = isDead[p2 - 1] = true;
                        } else {
                            isDead[p1 - 1] = true;
                        }
                    } else if (r1.equals("human") && strs[2].equals("N")){
                        if (s1 > s2) {
                            isDead[p2 - 1] = true;
                        }
                    } else if (r2.equals("human") && strs[3].equals("Y")) {
                        if (s1 > s2) {
                            isDead[p2 - 1] = true;
                        } else if (s1 == s2) {
                            isDead[p1 - 1] = isDead[p2 - 1] = true;
                        } else {
                            isDead[p1 - 1] = true;
                        }
                    } else if (r2.equals("human") && strs[3].equals("N")){
                        if (s1 < s2) {
                            isDead[p1 - 1] = true;
                        }
                    }

                }
            }
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < isDead.length; j++) {
                if (isDead[j]) {
                    s.append("N");
                } else {
                    s.append("Y");
                }
            }
            System.out.println(s.toString());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int t = in.nextInt();
            int[][] met = new int[n][6];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 4; j++) {
                    met[i][j] = in.nextInt();
                }
            }
            Map<String, Integer> ret = new HashMap<>();

        }
    }
}
