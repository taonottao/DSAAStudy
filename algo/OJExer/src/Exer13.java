/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/13 14:08
 */
public class Exer13 {
    /*
    给定两个32位整数n和m，同时给定i和j，将m的二进制数位插入到n的二进制的第j到第i位,保证n的第j到第i位均为零，
    且m的二进制位数小于等于i-j+1，其中二讲制的位数从O开始由低到高。
     */
    public int binInsert(int n, int m, int j, int i){
        m = m << j;
        return n | m;
    }
}
