package com.dzx.code.tool.leetcode;

import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] s1 = scanner.nextLine().split(" ");
        String[] s2 = scanner.nextLine().split(" ");
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        for(int i = 0; i < n;i++){
            nums1[i] = Integer.parseInt(s1[i]);
        }
        for(int i = 0; i < m;i++){
            nums2[i] = Integer.parseInt(s2[i]);
        }
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i<= n;i++){
            dp[i][0] = dp[i-1][0] + Math.abs(nums1[i-1]);
        }
        for(int i = 1; i<= m;i++){
            dp[0][i] = dp[0][i-1] + Math.abs(nums2[i-1]);
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int temp = Math.min(dp[i][j-1] + Math.abs(nums2[j-1]),dp[i-1][j] + Math.abs(nums1[i-1]));
                    dp[i][j] = Math.min(temp,dp[i-1][j-1] + Math.abs(nums1[i-1] - nums2[j-1]));
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
