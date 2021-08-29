package com.liang.offer;

public class MOffer13机器人的运动范围 {
    public static void main(String[] args) {
        System.out.println(movingCount(5,5,3));


    }
    static class NAll{
        private int n = 0;
        public NAll() {
            this.n = 0;
        }

        public int getN() {
            return n;
        }
        public void add(){
            this.n++;
        }
    }
    static
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        NAll nAll = new NAll();
        dp(visit,0, 0, k, nAll);
        return nAll.getN();
    }
    static public int sumDigits(int i){
        int sum = 0;
        while (i>0){
            sum+=i%10;
            i /= 10;
        }
        return sum;
    }
    static public void dp(boolean[][] visit,int i, int j, int k, NAll nAll){
        if(i>=visit.length || i<0 || j>=visit[0].length || j<0){
            return;
        }
        else if(visit[i][j]==false){
            visit[i][j]=true;
            if(sumDigits(i)+sumDigits(j)<=k){
                nAll.add();
                dp(visit, i+1, j, k, nAll);
                dp(visit, i-1, j, k, nAll);
                dp(visit, i, j-1, k, nAll);
                dp(visit, i, j+1, k, nAll);
            }else {
                return;
            }
        }
    }

}
