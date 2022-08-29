package com.dzx.code.tool.media;

import java.util.ArrayList;
import java.util.Arrays;

public class M2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = findPrimeNumber(1, 10);
        String s = list.toString();
        System.out.println(s);
    }
    public static ArrayList<Integer> findPrimeNumber (int m, int n) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = m; i <= n ; i++) {
            boolean flag = false;
            for (int j = 2; j*j <= i ; j++) {
                if(i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                list.add(i);
            }


        }
        return list;
    }
}
