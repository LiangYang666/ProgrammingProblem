package com.liang.剑指offerI;

public class MOffer44数字序列中的某一位数字 {
    public static void main(String[] args) {
        int n = 10000;
        System.out.println(findNthDigit(n));
        StringBuffer s = new StringBuffer();
        for (int i = 0;s.length()<n+1; i++) {
            s.append(i);
        }
        System.out.println(s.charAt(n));
    }

    static
    public int findNthDigit(int n) {
        if(n<10) return n;
        long temp=1;
        long i=0;
        while(temp<=n){
            temp += 9*(long)(Math.pow(10, i))*(i+1);
            i++;
        }
        i--;
        temp -= 9*(int)(Math.pow(10, i))*(i+1);
        temp = n-temp;
        //位数为i+1
        long num = temp/(i+1)+(long)Math.pow(10, i);
        long index = temp%(i+1);
        index = i+1-1-index;
        for (int j = 0; j < index; j++) {
            num=num/10;
        }
        return (int)(num%10);
    }

}
