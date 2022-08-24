package com.dzx.code.tool.newCoder;

public class JZ46 {
    public static void main(String[] args) {
        int solve = solve("160");
        System.out.println(solve);
    }
    public static int solve (String nums) {
        // write code here
        //难道不是动态规划吗
        int[] dp = new int[nums.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i < dp.length;i++){
            int a = nums.charAt(i-2) - '0';
            int b = nums.charAt(i-1) - '0';

            int temp = 10 * a + b;
            if(temp >= 10 && temp <= 26){
                if(b != 0){
                    dp[i] += dp[i-1];
                }
                dp[i] += dp[i-2];
            }else if(b != 0){
                dp[i] += dp[i-1];
            }

        }
        return dp[nums.length()];
    }
}
