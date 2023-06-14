import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/5 23:15
 */
public class Exer5 {
    /*
    小易来到了—条石板路前，每块石板上从1挨着编号为:1、2、3....
    小易来到了—条石板路前，每块石板上从1挨着编号为:1、2、3....
    这条石板路要根据特殊的规则才能前进:对于小易当前所在的编号为K的石板，小易单次只能往前跳K的一个约数
    (不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。小易当前处在编号为N的石板，
    他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
    例如:
    N= 4，M= 24:4->6->8->12->18->24
    于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
    */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // n 为初始石板位置
        int n = scanner.nextInt();
        // m 为目标石板位置
        int m = scanner.nextInt();
        // 该数组存放对应位置的跳跃次数
        int[] step = new int[m + 1];
        for(int i = 0; i < step.length; i++){
            step[i] = Integer.MAX_VALUE;
        }
        step[n] = 0;
        for(int i = n; i <= m; i++){
            if(step[i] == Integer.MAX_VALUE){
                continue;
            }
            List<Integer> list = div(i);
            // j 为跳跃的步数
            for(int j : list){
                if(i+j <= m && step[i+j]!= Integer.MAX_VALUE){
                    step[i+j] = Math.min(step[i+j], step[i]+1);
                }else if(i+j <= m){
                    step[i+j] = step[i] + 1;
                }
            }
        }

        if(step[m] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(step[m]);
        }
    }

    // 存储 num 的除 1 和 自身 的约数
    public static List<Integer> div(int num){
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                list.add(i);
                if( num / i != i){
                    list.add(num/i);
                }
            }
        }
        return list;
    }
}
