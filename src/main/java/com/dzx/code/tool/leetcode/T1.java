package com.dzx.code.tool.leetcode;

import java.util.Map;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] location = new int[3][2];

        for(int i = 0;i< 3;i++){
            location[i][0] = scanner.nextInt();
            location[i][1] = scanner.nextInt();
        }
        int[] dis = new int[3];
        int minX = n;
        int maxX = 0;
        int minY = n;
        int maxY = 0;
        for (int i = 0; i < 3; i++) {
            dis[i] = scanner.nextInt();
            minX = Math.min(location[i][0]-dis[i],minX);
            maxX = Math.max(location[i][0]+dis[i],maxX);
            minY = Math.min(location[i][1]-dis[i],minY);
            maxY = Math.max(location[i][1]+dis[i],maxY);
        }
        minX = minX <= 0? 1: minX;
        maxX = maxX > n? n:maxX;
        minY = minY <= 0? 1: minY;
        maxY = maxY > n? n:maxY;

        int x = 0, y = 0;
        for(int i = minX;i<=maxX;i++){
            for(int j = minY;j<=maxY;j++){
                boolean flag = true;
                for(int k = 0;k<3;k++){
                    int sum = Math.abs(i - location[k][0]) + Math.abs(j - location[k][1]);
                    if(sum != dis[k]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    x = i;
                    y = j;
                    System.out.println(x+" "+y);
                    return;
                }
                flag = true;






            }
        }

    }

}
