package exam;


import java.util.HashMap;

public class Demo16 {
    public static void main(String[] args) {
        String str = "([[])";
        int ret = match(str);
        System.out.println(ret);
    }
    public static int match (String s) {
        // write code here
        HashMap<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (hash.containsKey(ch)) {
                hash.put(ch, hash.get(ch) + 1);
            } else {
                hash.put(ch, 1);
            }
        }
        int a = 0, b = 0, c = 0, d = 0;
        if (hash.containsKey('(')) {
            a = hash.get('(');
        }
        if (hash.containsKey(')')) {
            b = hash.get(')');
        }
        if (hash.containsKey('[')) {
            c = hash.get('[');
        }
        if (hash.containsKey(']')) {
            d = hash.get(']');
        }
        int ret = Math.abs(a-b) + Math.abs(c-d);
        return ret;
    }
    public String fib2 (int f1, int f2, int n) {
        // write code here
        if(n == 1) return f1+"";
        if(n == 2) return f2+"";
        int a = f1;
        int b = f2;
        int c = 1;
        // 0  1  1  2  5  27
        for(int i = 3; i <= n; i++){
            c = a + b*b;
            a = b;
            b = c;
        }
        return c+"";
    }
}
