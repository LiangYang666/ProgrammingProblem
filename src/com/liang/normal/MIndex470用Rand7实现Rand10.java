package com.liang.normal;


public class MIndex470用Rand7实现Rand10 {

    public int rand7(){
        return (int)(Math.random()*7)+1;
    }
    public int rand10() {
        while(true){
            int a = rand7();
            int b =rand7();
            int ans = (a-1)*7+b;
            if(ans<40){
                return ans%10+1;
            }
        }
    }

    public int rand102() {
        int a,b;
        while ((a=rand7())>6);
        while ((b=rand7())>5);
        return ((a&1)==1)?b:b+5;
    }
}
