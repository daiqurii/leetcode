package com.dzx.code.tool.newCoder;

public class JZ50 {
    public int FirstNotRepeatingChar(String str) {
        //考虑大小写
        int[] count = new int[100];
        int[] index = new int[100];
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            count[c-'A'] ++;
            index[c - 'A'] = i;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 100; i++) {
            if(count[i] == 1){
                res = Math.min(res,index[i]);
            }
        }
        return (res == Integer.MAX_VALUE)? -1:res;
    }
}
