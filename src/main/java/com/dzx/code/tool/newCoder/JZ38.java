package com.dzx.code.tool.newCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JZ38 {
    public static void main(String[] args) {
        JZ38 jz38 = new JZ38();
        ArrayList<String> list = jz38.Permutation("qwertyuio");
        list.forEach(System.out::println);
    }

    public ArrayList<String> Permutation(String str) {
        // write code here
        // dfs加HashSet去重 复杂度O(N^N)

        char[] array = str.toCharArray();
//        ArrayList<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        dfs(array, 0, set);
        return new ArrayList<>(set);
    }

    public void dfs(char[] arr, int count, Set<String> list) {
        if (count == arr.length - 1) {
            list.add(new String(arr));
            return;
        }
        for (int i = count; i < arr.length; i++) {
            swap(arr,count,i);
            dfs(arr,count+1,list);
            swap(arr,count,i);
        }
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
