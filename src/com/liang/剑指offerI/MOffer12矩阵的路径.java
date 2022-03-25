package com.liang.剑指offerI;

public class MOffer12矩阵的路径 {
    public static void main(String[] args) {
        String[][] bd = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
        String[][] bd1 = {{"A"},{"S"},{"A"}};
        String[][] bd2 = {{"A","B","C","E"}};
        String[][] bd3 = {{"C","A","A"},{"A","A","A"},{"B","C","D"}};
        char[][] board = new char[bd.length][bd[0].length];
        for (int i = 0; i < bd.length; i++) {
            for (int j = 0; j < bd[0].length; j++) {
                board[i][j] = bd[i][j].charAt(0);
            }
        }
        System.out.println(exist(board, "AAB"));
    }
    static
    public boolean exist(char[][] board, String word) {
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0))
                    if(dp(board, i, j, word, 0, visit)){
                        return true;
                    }
            }
        }

        return false;
    }
    static public boolean dp(char[][] board,int i, int j, String word, int index, boolean[][] visit){

        if (i>=board.length || i<0 || j>=board[0].length || j<0)    return false;
        if (visit[i][j])    return false;
        if(board[i][j]==word.charAt(index)){
            index ++;
            if(index == word.length())  return true;
            else {
                visit[i][j] = true;
                boolean r = dp(board,i+1, j, word, index, visit) ||
                            dp(board,i-1, j, word, index, visit) ||
                            dp(board,i, j+1, word, index, visit) ||
                            dp(board,i, j-1, word, index, visit);

                visit[i][j] = false;
                return r;

            }
        }else {
            return false;
        }

    }
}
