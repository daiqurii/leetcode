package com.dzx.code.tool.newCoder;

public class JZ13 {
    int rows;
    int cols;
    public static void main(String[] args) {

    }
    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        return dfs(threshold,0,0,new boolean[rows][cols]);
    }
    public int dfs(int threshold,int row, int col, boolean[][] visited){
        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]){
            return 0;
        }
        if(countIndex(row) + countIndex(col) <= threshold){
            visited[row][col] = true;
            return 1 + dfs(threshold,row-1,col,visited)+dfs(threshold,row+1,col,visited)+
                    dfs(threshold,row,col-1,visited)+dfs(threshold,row,col+1,visited);
        }
        return 0;
    }

    public int countIndex(int n){
        int res = 0;
        while(n > 0){
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
