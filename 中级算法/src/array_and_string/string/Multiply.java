package array_and_string.string;

import java.util.Scanner;

/**
 * @description: 字符串相乘
 * @create: 2020-11-15-23:14
 * @author: Hey
 */

/**
 * 该算法是通过两数相乘时，乘数某位与被乘数某位相乘，与产生结果的位置的规律来完成。具体规律如下：
 * 乘数 num1 位数为 MM，被乘数 num2 位数为 NN， num1 x num2 结果 res 最大总位数为 M+N
 * num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x","xy"的形式)，其第一位位于 res[i+j]，
 * 第二位位于res[i+j+1]
 *
 */
public class Multiply {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();
        Multiply m = new Multiply();
        String ans = m.multiply(num1,num2);
        System.out.println(ans);
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num1.length()-1;i>=0;i--){
            int n1 = num1.charAt(i)-'0';
            for(int j = num2.length()-1;j>=0;j--){
                int n2 = num2.charAt(j)-'0';
                int sum = res[i+j+1]+n1*n2;
                res[i+j+1] = sum%10;
                res[i+j] += sum/10;
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i==0&&res[i]==0) continue;
            str.append(res[i]);
        }
        return str.toString();
    }
}
