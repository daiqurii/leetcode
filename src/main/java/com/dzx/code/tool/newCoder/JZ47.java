package com.dzx.code.tool.newCoder;

public class JZ47 {
    public int maxValue (int[][] grid) {
        // write code here
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row+1][col+1];
        for(int i = 1; i<= row;i++){
            for (int j = 1; j < col+1; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[row][col];
    }
}
