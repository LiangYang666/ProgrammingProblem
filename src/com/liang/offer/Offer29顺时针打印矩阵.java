package com.liang.offer;

public class Offer29顺时针打印矩阵 {
    static
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0) return new int[0];
        int l=0, t=0, r=matrix[0].length-1, b=matrix.length-1;
        int total = (r+1)*(b+1);
        int[] rs = new int[total];
        if(matrix[0].length==0) return rs;
        int i,j;
        int index=0;
        while(true){
            i=t;
            j=l;
            for (;j<=r;j++){
                rs[index++] = matrix[i][j];
            }
            if(index==total)    break;
            j--;
            i++;
            for(;i<=b;i++){
                rs[index++] = matrix[i][j];
            }
            if(index==total)    break;
            i--;
            j--;
            for (;j>=l;j--){
                rs[index++] = matrix[i][j];
            }
            if(index==total)    break;
            j++;
            i--;
            for (;i>=t+1;i--){
                rs[index++] = matrix[i][j];
            }
            if(index==total)    break;
            i++;
            l+=1;
            t+=1;
            b-=1;
            r-=1;
        }
        return rs;
    }

    public static void main(String[] args) {

    }
}
