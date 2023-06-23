/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/23 17:58
 */
public class Exer15 {
    public static void main(String[] args) {
        String s = solve("172.16.254.1");
        System.out.println(s);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 验证IP地址
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public static String solve (String IP) {
        // write code here
        if(isIPv4(IP)){
            return "IPv4";
        }
        if(isIPv6(IP)){
            return "IPv6";
        }
        return "Neither";
    }
    public static boolean isIPv4(String IP){
        if(IP.indexOf(".") == -1){
            return false;
        }

        String[] str = IP.split("\\.");
        if(str.length != 4){
            return false;
        }

        for(int i = 0; i < 4; i++){
            if(str[i].length() == 0){
                return false;
            }
            if(str[i].length() > 3 || (str[i].charAt(0) == '0' && str[i].length() != 1)){
                return false;
            }
            for(int j = 0; j < str[i].length(); j++){
                char c = str[i].charAt(j);
                if(c < '0' || c > '9'){
                    return false;
                }
            }
            int num = Integer.parseInt(str[i]);
            if(num > 255 || num < 0){
                return false;
            }

        }

        return true;
    }

    public static boolean isIPv6(String IP){
        if(IP.indexOf(":") == -1){
            return false;
        }
        String[] str = IP.split(":", -1);
        if(str.length != 8){
            return false;
        }

        for(int i = 0; i < 8; i++){
            if(str[i].length() == 0 || str[i].length() > 4){
                return false;
            }
            for(int j = 0; j < str[i].length(); j++){
                char c = str[i].charAt(j);
                if(!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || c >= 'A' && c <= 'F')){
                    return false;
                }
            }
        }

        return true;
    }
}


