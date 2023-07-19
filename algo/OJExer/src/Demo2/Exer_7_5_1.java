package Demo2;

import org.junit.Test;

import java.util.Scanner;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/5 15:02
 */
public class Exer_7_5_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int year1 = in.nextInt();
            int month1 = in.nextInt();
            int day1 = in.nextInt();
            int year2 = in.nextInt();
            int month2 = in.nextInt();
            int day2 = in.nextInt();
            int profit = 0;
            int gap = year2 - year1 - 1;
            for(int i = 1; i <= gap; i++){
                int year = year1 + i;
                profit += profitOfYear(year);
            }
            profit += profitOfThisYear(year2, month2, day2);
            profit += profitOfYear(year1) - profitOfThisYear(year1,month1,day1-1);
            if(year1 == year2){
                profit -= profitOfYear(year1);
            }
            System.out.println(profit);
        }
    }

    /**
     * 淘宝网店
     * NowCoder在淘宝上开了一家网店。他发现在月份为素数的时候，当月每天能赚1元；否则每天能赚2元。
     * 现在给你一段时间区间，请你帮他计算总收益有多少。
     */
    private static boolean isLeapYear(int year) {// 判断闰年
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    private static int profitOfYear(int year) {// 计算一年的收入

        return  2*31 +
                1*28 +
                1*31 +
                2*30 +
                1*31 +
                2*30 +
                1*31 +
                2*31 +
                2*30 +
                2*31 +
                1*30 +
                2*31 +
                (isLeapYear(year)? 1 : 0);
    }

    private static boolean isPrime(int month) {// 判断是否为素数月
        return month == 2 || month == 3 || month == 5 || month == 7 || month == 11;
    }

    private static int profitOfThisYear(int year,int month,int day) {//计算从该年开始到这年的日期收入!
        int profit = 0;
        if(isPrime(month)){
            profit += day;
        }else {
            profit += 2*day;
        }
        while (--month > 0){
            switch (month) {
                case 1: case 8: case 10: case 12:
                    profit += 2*31;
                    break;
                case 2:
                    profit += 28 + (isLeapYear(year)?1:0);
                    break;
                case 3: case 5: case 7:
                    profit += 31;
                    break;
                case 11:
                    profit += 30;
                    break;
                case 4: case 6: case 9:
                    profit += 30*2;
                    break;
            }
        }
        return profit;
    }

    @Test
    public void test1(){
        int i = profitOfYear(2000);
        System.out.println(i);
    }
}
