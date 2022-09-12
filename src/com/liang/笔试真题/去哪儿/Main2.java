package com.liang.笔试真题.去哪儿;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.笔试真题.去哪儿
 * @ClassName: Main2
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/9/7 13:50
 * @Version: 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public int Decrypt (int encryptedNumber, int decryption, int number) {
        // write code here
        BigInteger E = new BigInteger(String.valueOf(encryptedNumber));
        BigInteger D = new BigInteger(String.valueOf(decryption));
        BigInteger N = new BigInteger(String.valueOf(number));
        BigInteger pow1 = E.pow(decryption);
        BigInteger remainder = pow1.remainder(N);
        String s = remainder.toString();
        return Integer.parseInt(s);
    }
}
