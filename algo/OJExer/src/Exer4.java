import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/5 22:36
 */
public class Exer4 {
    // 编写一个程序, 解析输入在命令行的一行参数, 参数用空格分隔, ""之内的空格不算分隔符
    // 打印出参数个数, 以及所有参数

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            // 当遇到 " 时, 跳过
            if(str.charAt(i) == '"'){
                do{
                    i++;
                }while (str.charAt(i) != '"');
            }

            if(str.charAt(i) == ' '){
                count++;
            }
        }
        System.out.println(count + 1);

        // 当遇到 " 时, flag 与 1 进行 异或, 用来判断参数在 "" 内外
        int flag = 1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '"'){
                flag ^= 1;
            }
            if(str.charAt(i) != ' ' && str.charAt(i) != '"'){
                System.out.print(str.charAt(i));
            }
            if(str.charAt(i) == ' ' && flag == 0){
                System.out.print(str.charAt(i));
            }
            if(str.charAt(i) == ' ' && flag == 1){
                System.out.println();
            }
        }
    }
}
