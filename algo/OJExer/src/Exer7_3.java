/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/3 16:34
 */
public class Exer7_3 {

    public static void main(String[] args) {
//        System.out.println(judge(6));
        func(10);
        String s = "abcdef";
        String substring = s.substring(0, 5);
        System.out.println(substring);
    }

    public static String func(int num){
        String result = "" + num + " = ";
        for(int i = 2; i <= num; i++){
            if( num % i == 0 && judge(i)){
                num = num / i;
                result += i + " * ";
                i--;
            }
        }

        result = result.substring(0, result.length() - 2);

        return result;
    }
    public static boolean judge(int num){

        int flag = 0;

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            return true;
        }

        return false;
    }
}
