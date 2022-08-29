package com.dzx.code.tool.media;

import java.util.LinkedList;

public class M1 {
    public static void main(String[] args) {
        System.out.println(playNum(3, 3));
    }
    public static int playNum (int n, int m) {
        // write code here
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1;i<=n;i++){
            list.add(i);
        }
        int index = 0;
        while(list.size() > 1){
            int len = list.size();
            index = (index + m + len -1) % len;
            list.remove(index);
        }
        return list.get(0);
    }
}
