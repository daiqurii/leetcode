package com.dzx.code.tool.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] questions = new int[n];
            int[] score = new int[n];
            for (int i = 0; i < n; i++) {
                questions[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                score[i] = scanner.nextInt();
            }
            float plus = 0f;
            Ti[] tis = new Ti[n];

            for(int i = 0;i<n;i++){
                plus = (float) (score[i] * 1.0 - questions[i] * 0.01 * score[i]);
                tis[i] = new Ti(i,plus);
            }
            Arrays.sort(tis,(o1,o2)->{
                return (int) (o2.plus- o1.plus);
            });
            float ans = 0f;
            for(int i = 0;i<n && i<m;i++){
                tis[i].visited = true;
            }
            for(int i = 0;i<n;i++){
                if(tis[i].visited){
                    ans += score[tis[i].index]*1.0;
                }else {
                    ans += questions[tis[i].index]*0.01*score[tis[i].index];
                }
            }
            String format = String.format("%.2f", ans);
            System.out.println(format);
        }
    }
}
class Ti{
    int index;
    float plus;
    boolean visited = false;

    public Ti(int index, float plus) {
        this.index = index;
        this.plus = plus;
    }
}
